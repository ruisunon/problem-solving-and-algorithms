package ry.designpatterns.functionalGoF.strategy.context;

import ry.designpatterns.functionalGoF.strategy.strategies.AesEncryptionStrategy;
import ry.designpatterns.functionalGoF.strategy.strategies.BlowfishEncryptionStrategy;
import ry.designpatterns.functionalGoF.strategy.strategies.EncryptionStrategy;
import org.junit.Test;

import static org.junit.Assert.*;


public class EncryptorTest {

    @Test
    public void testEncrypt() throws Exception {
      EncryptionStrategy aesStrategy=new AesEncryptionStrategy();
      Encryptor aesEncryptor=new Encryptor(aesStrategy);
      aesEncryptor.setPlainText("This is plain text");
      aesEncryptor.encrypt();

        EncryptionStrategy blowfishStrategy=new BlowfishEncryptionStrategy();
        Encryptor blowfishEncryptor=new Encryptor(blowfishStrategy);
        blowfishEncryptor.setPlainText("This is plain text");
        blowfishEncryptor.encrypt();
    }
}