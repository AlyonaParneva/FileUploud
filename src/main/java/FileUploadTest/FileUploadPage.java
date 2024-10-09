package FileUploadTest;

public class FileUploadPage {
    private FileUploadAPI fileUploadAPI;

    public FileUploadPage(String publicKey) {
        this.fileUploadAPI = new FileUploadAPI(publicKey);
    }

    public String uploadFile(String filePath) {

        boolean authSuccessful = fileUploadAPI.authenticate();
        if (authSuccessful) {
            return fileUploadAPI.uploadFile(filePath);
        } else {


            return "Authentication failed. File upload aborted.";}
    }
}