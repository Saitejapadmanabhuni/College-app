package apple.teja.mycollegenotes.ebook;

public class EbookData2 {

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getPdfUrl2() {
        return pdfUrl2;
    }

    public void setPdfUrl2(String pdfUrl2) {
        this.pdfUrl2 = pdfUrl2;
    }

    private String name2 ,pdfUrl2;

    public EbookData2(){

    }

    public EbookData2(String name2, String pdfUrl2) {
        this.name2 = name2;
        this.pdfUrl2 = pdfUrl2;
    }


}
