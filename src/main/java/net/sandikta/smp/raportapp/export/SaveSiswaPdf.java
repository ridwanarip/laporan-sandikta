package net.sandikta.smp.raportapp.export;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import net.sandikta.smp.raportapp.dao.HibernateUtil;
import net.sandikta.smp.raportapp.dao.TahunPelajaranDao;
import net.sandikta.smp.raportapp.dao.interfaces.Dao;
import net.sandikta.smp.raportapp.entities.AbsensiSiswa;
import net.sandikta.smp.raportapp.entities.BudiPekertiSiswa;
import net.sandikta.smp.raportapp.entities.KegiatanSiswa;
import net.sandikta.smp.raportapp.entities.NilaiSiswa;
import net.sandikta.smp.raportapp.entities.TahunPelajaran;
import net.sandikta.smp.raportapp.entities.enums.NilaiKegiatan;

public class SaveSiswaPdf {

	private final static String LOGO_SANDIKTA = "/images/logo_sandikta.png";
	
	private static String checkKosong(KegiatanSiswa kegiatan) {
		if (kegiatan.getNilaiKegiatan() == NilaiKegiatan.KOSONG) {
			return "-";
		} else {
			return kegiatan.getNilaiKegiatan().toString();
		}
	}
	
	public static void saveSiswa(File file, TahunPelajaran tahunP) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Document document = new Document(PageSize.A4);
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Dao<TahunPelajaran, Long> daoTahunPelajaran = new TahunPelajaranDao();
			daoTahunPelajaran.setSession(session);
			
			TahunPelajaran tahunPelajaran = daoTahunPelajaran.findByID(tahunP.getIdTahunPelajaran());
			List<TahunPelajaran> listRanking = ((TahunPelajaranDao) daoTahunPelajaran).
					findByTahun(tahunP.getKelas(), tahunP.getSemester(), tahunP.getTahun());
			List<Double> totalRanking = listRanking.stream()
										.map(t -> t.getTotalNilai())
										.sorted(Comparator.reverseOrder())
										.collect(Collectors.toList());
			int ranking = totalRanking.indexOf(tahunPelajaran.getTotalNilai());
			
			for (TahunPelajaran tpp : listRanking) {
				System.out.println("Nama: " + tpp.getSiswa().getNama());
				System.out.println("Kelas: " + tpp.getKelas());
				System.out.println("Semester: " + tpp.getSemester());
				System.out.println("Nilai: " + tpp.getTotalNilai());
			}
			System.out.println("\n");
			for (Double d : totalRanking) {
				System.out.println("Nilai: " + d);
			}
			
			NilaiSiswa nilai1 = tahunPelajaran.getNilaiMatpel().get(0);
			NilaiSiswa nilai2 = tahunPelajaran.getNilaiMatpel().get(1);
			NilaiSiswa nilai3 = tahunPelajaran.getNilaiMatpel().get(2);
			NilaiSiswa nilai4 = tahunPelajaran.getNilaiMatpel().get(3);
			NilaiSiswa nilai5 = tahunPelajaran.getNilaiMatpel().get(4);
			NilaiSiswa nilai6 = tahunPelajaran.getNilaiMatpel().get(5);
			NilaiSiswa nilai7 = tahunPelajaran.getNilaiMatpel().get(6);
			NilaiSiswa nilai8 = tahunPelajaran.getNilaiMatpel().get(7);
			NilaiSiswa nilai9 = tahunPelajaran.getNilaiMatpel().get(8);
			NilaiSiswa nilai10 = tahunPelajaran.getNilaiMatpel().get(9);
			NilaiSiswa nilai11 = tahunPelajaran.getNilaiMatpel().get(10);
			NilaiSiswa nilai12 = tahunPelajaran.getNilaiMatpel().get(11);
			NilaiSiswa nilai13 = tahunPelajaran.getNilaiMatpel().get(12);
			KegiatanSiswa kegiatan1 = tahunPelajaran.getKegiatan().get(0);
			KegiatanSiswa kegiatan2 = tahunPelajaran.getKegiatan().get(1);
			KegiatanSiswa kegiatan3 = tahunPelajaran.getKegiatan().get(2);
			KegiatanSiswa kegiatan4 = tahunPelajaran.getKegiatan().get(3);
			KegiatanSiswa kegiatan5 = tahunPelajaran.getKegiatan().get(4);
			BudiPekertiSiswa akhlak = tahunPelajaran.getBudiPekerti().get(0);
			BudiPekertiSiswa kepribadian = tahunPelajaran.getBudiPekerti().get(1);
			AbsensiSiswa sakit = tahunPelajaran.getAbsensi().get(0);
			AbsensiSiswa izin = tahunPelajaran.getAbsensi().get(1);
			AbsensiSiswa tanpaKeterangan = tahunPelajaran.getAbsensi().get(2);
			
			
			PdfWriter.getInstance(document, new FileOutputStream(file));
			PdfPCell cell1, cell2, cell3, cell4, cell5, cell6;
			document.open();
			Image logo = Image.getInstance(SaveSiswaPdf.class.getResource(LOGO_SANDIKTA));
			logo.scaleToFit(90, 90);
			
			// Table 1
			PdfPTable table1 = new PdfPTable(2);
			table1.setWidthPercentage(100);
			table1.setWidths(new int[] {1, 4});
			
			cell1 = new PdfPCell(logo);
			cell1.setRowspan(5);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(cell1);
			
			cell1 = new PdfPCell(new Phrase("YAYASAN  PENDIDIKAN  KITA (SANDIKTA)", FontFactory.
					getFont(FontFactory.defaultEncoding, 12)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(cell1);
			cell1 = new PdfPCell(new Phrase("SEKOLAH MENENGAH PERTAMA", FontFactory.
					getFont(FontFactory.defaultEncoding, 12)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(cell1);
			cell1 = new PdfPCell(new Phrase("SMP SANDIKTA", FontFactory.
					getFont(FontFactory.defaultEncoding, 20, Font.BOLD)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(cell1);
			cell1 = new PdfPCell(new Phrase("Notaris : Ny. H. Nazli Alida Lubis,  S.H. No. 05", 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(cell1);
			cell1 = new PdfPCell(new Phrase("Alamat : Jalan Raya Hankam No. 208 Pondok Melati Kota Bekasi, "
					+ "Kode Pos : 17414", FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(cell1);
			cell1 = new PdfPCell(new Phrase("Tlp. (021) 8466569  Fax : (021) 84972414  "
					+ "Website: http://smp.sandikta.net E-mail: smp@sandikta.net", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell1);
			
			LineSeparator line = new LineSeparator();
			line.setOffset(-3);
			
			// Table 2
			PdfPTable table2 = new PdfPTable(5);
			table2.setWidthPercentage(100);
			table2.setWidths(new int[] {2, 4, 1, 2, 3});
			table2.setSpacingBefore(10);
			
			cell2 = new PdfPCell(new Phrase("Nama Sekolah", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell2);
			cell2 = new PdfPCell(new Phrase(":  SMP SANDIKTA", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell2);
			cell2 = new PdfPCell(new Phrase(" "));
			cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell2);
			cell2 = new PdfPCell(new Phrase("Kelas", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell2);
			cell2 = new PdfPCell(new Phrase(":  " + tahunPelajaran.getKelas(), FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell2);
			cell2 = new PdfPCell(new Phrase("Alamat", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell2);
			cell2 = new PdfPCell(new Phrase(":  Jl. Raya Hankam No. 208", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell2);
			cell2 = new PdfPCell(new Phrase(" "));
			cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell2);
			cell2 = new PdfPCell(new Phrase("Semester", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell2);
			cell2 = new PdfPCell(new Phrase(":  " + tahunPelajaran.getSemester(), FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell2);
			cell2 = new PdfPCell(new Phrase("Nama Siswa", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell2);
			cell2 = new PdfPCell(new Phrase(":  " + tahunPelajaran.getSiswa().getNama(), FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell2);
			cell2 = new PdfPCell(new Phrase(" "));
			cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell2);
			cell2 = new PdfPCell(new Phrase("Tahun Pelajaran", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell2);
			cell2 = new PdfPCell(new Phrase(":  " + tahunPelajaran.getTahun(), FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell2);
			cell2 = new PdfPCell(new Phrase("Nomor Induk", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell2);
			cell2 = new PdfPCell(new Phrase(":  " + tahunPelajaran.getSiswa().getNoInduk(), FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell2.setColspan(4);
			cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell2);
			
			// Table 3
			PdfPTable table3 = new PdfPTable(6);
			table3.setWidthPercentage(100);
			table3.setWidths(new int[] {1, 7, 2, 3, 6, 4});
			table3.setSpacingBefore(10);
			
			cell3 = new PdfPCell(new Phrase("No", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setRowspan(2);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table3.addCell(cell3);
			
			cell3 = new PdfPCell(new Phrase("Mata Pelajaran", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setRowspan(2);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table3.addCell(cell3);
			
			cell3 = new PdfPCell(new Phrase("KKM", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setRowspan(2);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table3.addCell(cell3);
			
			cell3 = new PdfPCell(new Phrase("Nilai", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setColspan(2);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			
			cell3 = new PdfPCell(new Phrase("Deskripsi Kemajuan Belajar", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setRowspan(2);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table3.addCell(cell3);
			
			cell3 = new PdfPCell(new Phrase("Angka", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			
			cell3 = new PdfPCell(new Phrase("Huruf", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			
			// Nilai 1
			cell3 = new PdfPCell(new Phrase("1", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai1.getNamaPelajaran()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai1.getKkm()), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai1.getNilaiAngka()).replace(".0", ""), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(nilai1.getNilaiHuruf(), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai1.getKeterangan()).replace("_", " "), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			
			// Nilai 2
			cell3 = new PdfPCell(new Phrase("2", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai2.getNamaPelajaran()).
					replace("_", " "),FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai2.getKkm()), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai2.getNilaiAngka()).replace(".0", ""), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(nilai2.getNilaiHuruf(), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai2.getKeterangan()).replace("_", " "), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			
			// Nilai 3
			cell3 = new PdfPCell(new Phrase("3", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai3.getNamaPelajaran()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai3.getKkm()), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai3.getNilaiAngka()).replace(".0", ""), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(nilai3.getNilaiHuruf(), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai3.getKeterangan()).replace("_", " "), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			
			// Nilai 4
			cell3 = new PdfPCell(new Phrase("4", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai4.getNamaPelajaran()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai4.getKkm()), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai4.getNilaiAngka()).replace(".0", ""), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(nilai4.getNilaiHuruf(), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai4.getKeterangan()).replace("_", " "), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			
			// Nilai 5
			cell3 = new PdfPCell(new Phrase("5", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai5.getNamaPelajaran()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai5.getKkm()), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai5.getNilaiAngka()).replace(".0", ""), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(nilai5.getNilaiHuruf(), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai5.getKeterangan()).replace("_", " "), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			
			// Nilai 6
			cell3 = new PdfPCell(new Phrase("6", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai6.getNamaPelajaran()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai6.getKkm()), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai6.getNilaiAngka()).replace(".0", ""), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(nilai6.getNilaiHuruf(), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai6.getKeterangan()).replace("_", " "), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			
			// Nilai 7
			cell3 = new PdfPCell(new Phrase("7", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai7.getNamaPelajaran()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai7.getKkm()), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai7.getNilaiAngka()).replace(".0", ""), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(nilai7.getNilaiHuruf(), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai7.getKeterangan()).replace("_", " "), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);

			// Nilai 8
			cell3 = new PdfPCell(new Phrase("8", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai8.getNamaPelajaran()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai8.getKkm()), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai8.getNilaiAngka()).replace(".0", ""), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(nilai8.getNilaiHuruf(), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai8.getKeterangan()).replace("_", " "), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			
			// Nilai 9
			cell3 = new PdfPCell(new Phrase("9", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai9.getNamaPelajaran()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai9.getKkm()), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai9.getNilaiAngka()).replace(".0", ""), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(nilai9.getNilaiHuruf(), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai9.getKeterangan()).replace("_", " "), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			
			// Nomor 10 (Kosong)
			cell3 = new PdfPCell(new Phrase("10", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setRowspan(3);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table3.addCell(cell3);
			
			// Pilihan
			cell3 = new PdfPCell(new Phrase("Pilihan ***)", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(" "));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(" "));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(" "));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(" "));
			table3.addCell(cell3);
			
			// Nilai 10 a (Keterampilan)
			cell3 = new PdfPCell(new Phrase("a. " + String.valueOf(nilai10.getNamaPelajaran()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai10.getKkm()), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai10.getNilaiAngka()).replace(".0", ""), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(nilai10.getNilaiHuruf(), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai10.getKeterangan()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			
			// Nilai 10 b
			cell3 = new PdfPCell(new Phrase("b. " + String.valueOf(nilai11.getNamaPelajaran()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai11.getKkm()), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai11.getNilaiAngka()).replace(".0", ""), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(nilai11.getNilaiHuruf(), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai11.getKeterangan()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			
			// Nomor 11 (Kosong)
			cell3 = new PdfPCell(new Phrase("11", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell3.setRowspan(3);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table3.addCell(cell3);
			
			// Muatan Lokal
			cell3 = new PdfPCell(new Phrase("Muatan Lokal ***)", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(" "));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(" "));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(" "));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(" "));
			table3.addCell(cell3);
			
			// Nilai 11 a
			cell3 = new PdfPCell(new Phrase("a. " + String.valueOf(nilai12.getNamaPelajaran()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai12.getKkm()), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai12.getNilaiAngka()).replace(".0", ""), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(nilai12.getNilaiHuruf(),
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai12.getKeterangan()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			
			// Nilai 11 b
			cell3 = new PdfPCell(new Phrase("b. " + String.valueOf(nilai13.getNamaPelajaran()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai13.getKkm()), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai13.getNilaiAngka()).replace(".0", ""), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(nilai13.getNilaiHuruf(),
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table3.addCell(cell3);
			cell3 = new PdfPCell(new Phrase(String.valueOf(nilai13.getKeterangan()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(cell3);
			
			// Table 4
			PdfPTable table4 = new PdfPTable(5);
			table4.setWidthPercentage(100);
			table4.setWidths(new int[] {1, 10, 3, 6, 3});
			table4.setSpacingBefore(10);
			
			cell4 = new PdfPCell(new Phrase("No", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase("Kegiatan Pengembangan Diri", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase("Nilai", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase("Keterangan", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell4.setColspan(2);
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4.addCell(cell4);
			
			// Kegiatan 1
			cell4 = new PdfPCell(new Phrase("1", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(String.valueOf(kegiatan1.getNamaKegiatan()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(String.valueOf(checkKosong(kegiatan1)), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase("Jumlah Nilai", 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(String.valueOf(tahunPelajaran.getTotalNilai()).replace(".0", ""), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4.addCell(cell4);
			
			// Kegiatan 2
			cell4 = new PdfPCell(new Phrase("2", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(String.valueOf(kegiatan2.getNamaKegiatan()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(checkKosong(kegiatan2), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase("Peringkat", 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(String.valueOf(++ranking),
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4.addCell(cell4);
			
			// Kegiatan 3
			cell4 = new PdfPCell(new Phrase("3", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(String.valueOf(kegiatan3.getNamaKegiatan()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(checkKosong(kegiatan3), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(" "));
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(" "));
			table4.addCell(cell4);
			
			// Kegiatan 4
			cell4 = new PdfPCell(new Phrase("4", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(String.valueOf(kegiatan4.getNamaKegiatan()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(checkKosong(kegiatan4), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(" "));
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(" "));
			table4.addCell(cell4);
			
			// Kegiatan 5
			cell4 = new PdfPCell(new Phrase("5", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(String.valueOf(kegiatan5.getNamaKegiatan()).
					replace("_", " "), FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(checkKosong(kegiatan5), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(" "));
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Phrase(" "));
			table4.addCell(cell4);
			
			// Table 5
			PdfPTable table5 = new PdfPTable(4);
			table5.setWidthPercentage(100);
			table5.setWidths(new int[] {3, 3, 3, 3});
			table5.setSpacingBefore(10);
			
			cell5 = new PdfPCell(new Phrase("Akhlak dan Kepribadian", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell5.setColspan(2);
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			table5.addCell(cell5);
			
			cell5 = new PdfPCell(new Phrase("Ketidakhadiran", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell5.setColspan(2);
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			table5.addCell(cell5);
			
			// Row 1
			cell5 = new PdfPCell(new Phrase(String.valueOf(akhlak.getNamaBudiPekerti()).replace("_", " "), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table5.addCell(cell5);
			
			cell5 = new PdfPCell(new Phrase(String.valueOf(akhlak.getNilaiBudiPekerti()).replace("_", " "), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table5.addCell(cell5);
			
			cell5 = new PdfPCell(new Phrase(sakit.getNamaAbsensi().toString(), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table5.addCell(cell5);
			
			cell5 = new PdfPCell(new Phrase(sakit.getJumlah().toString() + "   Hari", 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table5.addCell(cell5);
			
			// Row 2
			cell5 = new PdfPCell(new Phrase(String.valueOf(kepribadian.getNamaBudiPekerti()).replace("_", " "), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table5.addCell(cell5);
			
			cell5 = new PdfPCell(new Phrase(String.valueOf(kepribadian.getNilaiBudiPekerti()).replace("_", " "), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table5.addCell(cell5);
			
			cell5 = new PdfPCell(new Phrase(izin.getNamaAbsensi().toString(), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table5.addCell(cell5);
			
			cell5 = new PdfPCell(new Phrase(izin.getJumlah().toString() + "   Hari", 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table5.addCell(cell5);
			
			// Row 3
			cell5 = new PdfPCell(new Phrase(" "));
			table5.addCell(cell5);
			
			cell5 = new PdfPCell(new Phrase(" "));
			table5.addCell(cell5);
			
			cell5 = new PdfPCell(new Phrase(String.valueOf(tanpaKeterangan.getNamaAbsensi()).replace("_", " "), 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table5.addCell(cell5);
			
			cell5 = new PdfPCell(new Phrase(tanpaKeterangan.getJumlah().toString() + "   Hari", 
					FontFactory.getFont(FontFactory.defaultEncoding, 10)));
			table5.addCell(cell5);
			
			PdfPTable table6 = new PdfPTable(3);
			table6.setWidthPercentage(100);
			table6.setWidths(new int[] {4, 2, 4});
			table6.setSpacingBefore(10);
			
			// Row 1
			cell6 = new PdfPCell(new Phrase("Mengetahui, ", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			
			cell6 = new PdfPCell(new Phrase(" "));
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			
			
			
			cell6 = new PdfPCell(new Phrase("Bekasi, " + String.valueOf(
					new SimpleDateFormat("dd/MM/yyyy").format(new Date())), 
					FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			
			// Row 2
			cell6 = new PdfPCell(new Phrase("Orang Tua / Wali Murid", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			
			cell6 = new PdfPCell(new Phrase(" "));
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			
			cell6 = new PdfPCell(new Phrase("Wali Kelas, ", FontFactory.
					getFont(FontFactory.defaultEncoding, 10)));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			
			// Row 3
			cell6 = new PdfPCell(new Phrase(" "));
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			cell6 = new PdfPCell(new Phrase(" "));
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			cell6 = new PdfPCell(new Phrase(" "));
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			
			// Row 4
			cell6 = new PdfPCell(new Phrase(" "));
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			cell6 = new PdfPCell(new Phrase(" "));
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			cell6 = new PdfPCell(new Phrase(" "));
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			
			// Row 5
			cell6 = new PdfPCell(new Phrase(" "));
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			cell6 = new PdfPCell(new Phrase(" "));
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			cell6 = new PdfPCell(new Phrase(" "));
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			
			// Row 6
			cell6 = new PdfPCell(new Phrase("------------------------------"));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			cell6 = new PdfPCell(new Phrase(" "));
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			cell6 = new PdfPCell(new Phrase("------------------------------"));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell6.setBorder(Rectangle.NO_BORDER);
			table6.addCell(cell6);
			
			document.add(table1);
			document.add(line);
			document.add(table2);
			document.add(table3);
			document.add(table4);
			document.add(table5);
			document.add(table6);
			document.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}