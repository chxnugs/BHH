package main.pt.ipleiria.estg.dei.utils;

import main.pt.ipleiria.estg.dei.BrowserHistoryReportConfigurationPanel;
import main.pt.ipleiria.estg.dei.db.DatasetRepository;
import main.pt.ipleiria.estg.dei.exceptions.ConnectionException;
import main.pt.ipleiria.estg.dei.exceptions.GenerateReportException;
import main.pt.ipleiria.estg.dei.model.Email;
import main.pt.ipleiria.estg.dei.model.User;
import main.pt.ipleiria.estg.dei.model.Website;
import main.pt.ipleiria.estg.dei.model.Word;
import main.pt.ipleiria.estg.dei.utils.report.Generator;
import main.pt.ipleiria.estg.dei.utils.report.ReportParameterMap;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileGenerator {
    private Logger<FileGenerator> logger;
    private BrowserHistoryReportConfigurationPanel configPanel;
    private Class from;
    private String reportDir;

    public FileGenerator(BrowserHistoryReportConfigurationPanel configPanel, Class from, String reportDir) {
        this.configPanel = configPanel;
        this.from = from;
        this.reportDir = reportDir;
        logger = new Logger<>(FileGenerator.class);
    }

    public void generatePDF() throws ConnectionException, SQLException, ClassNotFoundException, JRException, GenerateReportException, IOException {
        InputStream templateFile = from.getResourceAsStream("/resources/template/autopsy.jrxml");

        Generator generator = new Generator(templateFile);

        Map<String, Object> reportData = new HashMap<>();

        reportData.put("isMostVisitedSitesEnabled", configPanel.isMostVisitedSitesEnabled());
        if(configPanel.isMostVisitedSitesEnabled()) {
            List<Website> topMostVisited = DatasetRepository.getInstance().getTopVisitedWebsite(10);
            reportData.put("Title", "Most visited websites");
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(topMostVisited);
            reportData.put("Visits", jrBeanCollectionDataSource);
        }

        reportData.put("isBlokedSitesEnabled", configPanel.isBlokedSitesEnabled());
        if(configPanel.isBlokedSitesEnabled()) {
            List<Website> blockedWebsitesVisited = DatasetRepository.getInstance().getBlockedWebsiteVisited();
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(blockedWebsitesVisited);
            reportData.put("Blocked", jrBeanCollectionDataSource);
        }

        reportData.put("isWordsSearchEnabled", configPanel.isWordsSearchEnabled());
        if(configPanel.isWordsSearchEnabled()) {
            List<Word> wordUsed = DatasetRepository.getInstance().getWordsUsed();
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(wordUsed);
            reportData.put("Words", jrBeanCollectionDataSource);
        }

        if(configPanel.isWordsSearchEnabled()) {
            List<Email> emailsUsed = DatasetRepository.getInstance().getEmailsUsed();
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(emailsUsed);
            reportData.put("Emails", jrBeanCollectionDataSource);
        }

        List<User> usersInfo = new ArrayList<>();
        List<Website> topVisitedWebsiteByUser;
        List<Website> blockedWebsiteVisited;

        List<String> userNames = configPanel.getUsersSelected();//TODO: Be sure that it is not null...

        for (String nome: userNames ) {
            topVisitedWebsiteByUser = DatasetRepository.getInstance().getTopVisitedWebsiteByUser(7, nome);
            blockedWebsiteVisited = DatasetRepository.getInstance().getBlockedWebsiteVisited(7, nome);

            usersInfo.add(new User(nome, topVisitedWebsiteByUser, blockedWebsiteVisited));
        }


        JRDataSource userInfo = new JRBeanCollectionDataSource(usersInfo);

        //Visited Subreport List (by user)
        reportData.put("UserInfo", userInfo);


        //Adding SubReport (Chart Type)
        InputStream chartTipe;
        if(configPanel.isChartBarTipe()){
            chartTipe = from.getResourceAsStream("/resources/template/user_graf.jrxml");
        }else{
            chartTipe = from.getResourceAsStream("/resources/template/user_graf_pie.jrxml");
        }


        JasperReport subReportChart = JasperCompileManager.compileReport(chartTipe);
        reportData.put("subReport", subReportChart);


        generator.setReportData(reportData);

        ReportParameterMap reportParameters = new ReportParameterMap();
        // Generate the document into a byte array.
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        reportParameters.setOutputStream(byteArrayOutputStream);
        generator.setReportParameters(reportParameters);

        generator.generateReport();

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss-SS");
        Date date = new Date();
        String dateNoTime = dateFormat.format(date);

        try(OutputStream outputStream = new FileOutputStream(reportDir + "\\generatedReport"+ dateNoTime +".pdf")) {
            byteArrayOutputStream.writeTo(outputStream);
        }
    }


    public  void generateCSV() {
        Map<String, String> queries = configPanel.getQueries();
        if (!queries.isEmpty()) {
            queries.forEach((key, value) -> {
                try {
                    Utils.writeCsv(DatasetRepository.getInstance().execute(value), reportDir + "\\" + key);
                } catch (ConnectionException | ClassNotFoundException | SQLException e) {
                    logger.warn("Couldn't extract query: " + value);
                }
            });
        }
    }
}
