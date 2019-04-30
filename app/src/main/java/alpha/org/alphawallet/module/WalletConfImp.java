package alpha.org.alphawallet.module;

import android.content.SharedPreferences;

import org.sendj.core.Context;
import org.sendj.core.NetworkParameters;

import global.WalletConfiguration;
import alpha.org.alphawallet.utils.Configurations;

import static alpha.org.alphawallet.module.AlphaContext.CONTEXT;
import static alpha.org.alphawallet.module.AlphaContext.Files.BLOCKCHAIN_FILENAME;
import static alpha.org.alphawallet.module.AlphaContext.Files.CHECKPOINTS_FILENAME;
import static alpha.org.alphawallet.module.AlphaContext.Files.WALLET_FILENAME_PROTOBUF;
import static alpha.org.alphawallet.module.AlphaContext.Files.WALLET_KEY_BACKUP_PROTOBUF;
import static alpha.org.alphawallet.module.AlphaContext.NETWORK_PARAMETERS;
import static alpha.org.alphawallet.module.AlphaContext.PEER_DISCOVERY_TIMEOUT_MS;
import static alpha.org.alphawallet.module.AlphaContext.PEER_TIMEOUT_MS;

/**
 * Created by kaali on 6/4/17.
 */

public class WalletConfImp extends Configurations implements WalletConfiguration {

    private static final String PREF_TRUSTED_NODE = "trusted_node";
    private static final String PREFS_KEY_SCHEDULE_BLOCKCHAIN_SERVICE = "sch_block_serv";

    public WalletConfImp(SharedPreferences prefs) {
        super(prefs);
    }

    @Override
    public String getTrustedNodeHost() {
        return getString(PREF_TRUSTED_NODE,null);
    }

    @Override
    public void saveTrustedNode(String host, int port) {
        save(PREF_TRUSTED_NODE,host);
    }

    @Override
    public void saveScheduleBlockchainService(long time){
        save(PREFS_KEY_SCHEDULE_BLOCKCHAIN_SERVICE,time);
    }

    @Override
    public long getScheduledBLockchainService(){
        return getLong(PREFS_KEY_SCHEDULE_BLOCKCHAIN_SERVICE,0);
    }

    @Override
    public int getTrustedNodePort() {
        return AlphaContext.NETWORK_PARAMETERS.getPort();
    }

    @Override
    public String getMnemonicFilename() {
        return AlphaContext.Files.BIP39_WORDLIST_FILENAME;
    }

    @Override
    public String getWalletProtobufFilename() {
        return WALLET_FILENAME_PROTOBUF;
    }

    @Override
    public NetworkParameters getNetworkParams() {
        return AlphaContext.NETWORK_PARAMETERS;
    }

    @Override
    public String getKeyBackupProtobuf() {
        return WALLET_KEY_BACKUP_PROTOBUF;
    }

    @Override
    public long getWalletAutosaveDelayMs() {
        return AlphaContext.Files.WALLET_AUTOSAVE_DELAY_MS;
    }

    @Override
    public Context getWalletContext() {
        return CONTEXT;
    }

    @Override
    public String getBlockchainFilename() {
        return BLOCKCHAIN_FILENAME;
    }

    @Override
    public String getCheckpointFilename() {
        return CHECKPOINTS_FILENAME;
    }

    @Override
    public int getPeerTimeoutMs() {
        return PEER_TIMEOUT_MS;
    }

    @Override
    public long getPeerDiscoveryTimeoutMs() {
        return PEER_DISCOVERY_TIMEOUT_MS;
    }

    @Override
    public int getMinMemoryNeeded() {
        return AlphaContext.MEMORY_CLASS_LOWEND;
    }

    @Override
    public long getBackupMaxChars() {
        return AlphaContext.BACKUP_MAX_CHARS;
    }

    @Override
    public boolean isTest() {
        return AlphaContext.IS_TEST;
    }

    @Override
    public int getProtocolVersion() {
        return NETWORK_PARAMETERS.getProtocolVersionNum(NetworkParameters.ProtocolVersion.CURRENT);
    }

}
