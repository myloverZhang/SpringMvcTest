package ct.dc.pc.api.dao;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ct.dc.libinfrastructure.CommonUtils;
import ct.dc.mongodb.IMongoDB;
import ct.dc.mongodb.impl.MongoDBImpl;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by B41-80 on 2017/1/5.
 */
@PropertySource(value = "classpath:mongo.properties")
public  class RepositoryBase {
    Logger logger = Logger.getLogger(RepositoryBase.class);
    private IMongoDB client;
    private MongoDatabase database;
    private String mongoUri;
    private String dataBaseName;
    private String collectionName;
    private String userName;
    private String passWord;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setMongoUri(String mongoUri) {
        this.mongoUri = mongoUri;
    }

    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    /**
     * 获取mongo连接
     * @return
     */
    public IMongoDB getMongo()
    {
        if (client == null)
        {
            try {
                client = new MongoDBImpl(mongoUri,userName,passWord);
                getMongo().useDatabase(dataBaseName);
            }catch (Exception ex)
            {
                logger.error(String.format("初始化mongo错误：%s;mongoUri:%s", CommonUtils.getStackErrors(ex), mongoUri));
            }
        }
        return client;
    }

    /**
     * 获取数据库
     * @return
     */
    public MongoDatabase getDatabaseByName()
    {
        if (database==null)
        {
            getMongo().useDatabase(dataBaseName);
        }
        return database;
    }

    /**
     * 获取集合
     * @return
     */
    public MongoCollection<Document> collectionInstance()
    {
        return getMongo().getCollection(collectionName);
    }
}
