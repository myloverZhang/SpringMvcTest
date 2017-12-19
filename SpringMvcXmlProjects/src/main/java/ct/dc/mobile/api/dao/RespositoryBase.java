package ct.dc.mobile.api.dao;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.log4j.Logger;
import org.bson.Document;

/**
 * Created by B41-80 on 2017/1/5.
 */
public  class RespositoryBase {
    Logger logger = Logger.getLogger(RespositoryBase.class);
    private MongoClient client;
    private MongoDatabase database;
    private String mongoUri;
    private String dataBaseName;
    private String collectionName;

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
    public MongoClient getMongo()
    {
        if (client == null)
        {
            try {
                MongoClientURI uri = new MongoClientURI(mongoUri);
                client = new MongoClient(uri);
            }catch (Exception ex)
            {
                ex.printStackTrace();
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
            database = getMongo().getDatabase(dataBaseName);
        }
        return database;
    }

    /**
     * 获取集合
     * @return
     */
    public MongoCollection<Document> collectionInstance()
    {
        return getDatabaseByName().getCollection(collectionName);
    }
}
