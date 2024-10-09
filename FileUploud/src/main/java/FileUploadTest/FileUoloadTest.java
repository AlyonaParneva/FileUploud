package FileUploadTest;

public class FileUoloadTest {
    public static void main(String[] args) {

        FileUploadPage fileUploadPage = new FileUploadPage();

        String filePath = "C://Users//aparneva//Downloads//document.pdf";
        String result = fileUploadPage.uploadFile(filePath);
        System.out.println("Response from server: " + result);
    }
}
