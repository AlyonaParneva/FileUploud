package FileUploadTest;

public class FileUploadPage {
    private FileUploadAPI fileUploadAPI;

    public FileUploadPage() {
        this.fileUploadAPI = new FileUploadAPI();
    }

    public String uploadFile(String filePath) {
        return fileUploadAPI.uploadFile(filePath);
    }
}