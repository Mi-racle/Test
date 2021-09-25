package EncryptionOperation;

public class EncryptionOperation extends DataEncryption implements DataOperation {
    @Override
    public String operation (String data) {
        super.encryption(data);
        return data;
    }
}
