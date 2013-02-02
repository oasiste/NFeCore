package br.com.usicamp.nfe.core.danfe;

import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import br.com.usicamp.nfe.core.dto.NFe;


public class Danfe {
	
	
	
	@SuppressWarnings("unchecked")
	public static void gerarDanfe(NFe nfe,String diretorioExport) throws JRException {
        gerarDanfe(nfe, diretorioExport, System.getProperty("user.dir"));
    }
	
	@SuppressWarnings("unchecked")
	public static void gerarDanfe(NFe nfe,String diretorioExport,String diretorioJasper) throws JRException {
        JasperReport relatorioJasper = (JasperReport) JRLoader.loadObject(diretorioJasper+"\\Danfe2.jasper");
        Collection collection = new java.util.Vector();
        collection.add(nfe);
        HashMap hashMap = new HashMap();
//        hashMap.put("SUBREPORT_DIR", diretorioJasper+"\\");
        hashMap.put("SUBREPORT_DIR", diretorioJasper);
        JasperPrint jasperPrint = JasperFillManager.fillReport(relatorioJasper,hashMap, new JRBeanCollectionDataSource(collection));
        JasperExportManager.exportReportToPdfFile(jasperPrint, diretorioExport+"\\"+nfe.getId().substring(3).concat(".pdf"));
    }
	
	public static byte[] getDanfeByte(NFe nfe,String pathJasper, Object parametros) throws JRException{
		
		JasperReport relatorioJasper = (JasperReport) JRLoader.loadObject(pathJasper);
		Collection collection = new java.util.Vector();
        collection.add(nfe);
        HashMap hashMap = new HashMap();
        hashMap.put("PARAMETROS", parametros);
        JasperPrint jasperPrint = JasperFillManager.fillReport(relatorioJasper,hashMap, new JRBeanCollectionDataSource(collection));
        
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JRExporter jrExporter = new JRPdfExporter();
        jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
        jrExporter.exportReport();
        
		return byteArrayOutputStream.toByteArray();
	}

	
}
