package FileUploadTest;

public class FileUoloadTest {
    public static void main(String[] args) {
        String publicKey = "secret_key_805ef3e5227be79cd3b3c82d04b13701_FD3mo34181e0a33b744983e7a24c2b56ae275";
        FileUploadAPI fileUploadAPI = new FileUploadAPI(publicKey);

        boolean authSuccessful = fileUploadAPI.authenticate();
        if (authSuccessful) {
            System.out.println("Authentication successful.");

            String uploadResponse = fileUploadAPI.uploadFile("C://Users//aparneva//Downloads//document.pdf");
            System.out.println("Response from server: " + uploadResponse);
        } else {
            System.out.println("Authentication failed.");
        }
    }
}
