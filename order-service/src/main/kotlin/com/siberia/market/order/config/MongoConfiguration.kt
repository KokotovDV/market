//package com.siberia.market.order.config
//
//import com.mongodb.MongoClientSettings
//import com.mongodb.reactivestreams.client.MongoClient
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.boot.autoconfigure.mongo.MongoProperties
//import org.springframework.boot.context.properties.EnableConfigurationProperties
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory
//import org.springframework.data.mongodb.ReactiveMongoTransactionManager
//import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
//import org.springframework.transaction.ReactiveTransactionManager
//
//@Configuration
//class MongoConfiguration(
//    private val mongoProperties: MongoProperties
//): AbstractReactiveMongoConfiguration() {
//
//    @Bean
//    fun mongoClient(): MongoClient {
//        return reactiveMongoClient()
//    }
//
//    override fun getDatabaseName(): String {
//        return mongoProperties.database
//    }
//
//    //    override fun mongoClientSettings(): MongoClientSettings {
////        return super.mongoClientSettings()
////    }
//
//    //    MongoClient
////
//    @Bean
//    fun transactionManager(databaseFactory: ReactiveMongoDatabaseFactory) : ReactiveTransactionManager {
//        return ReactiveMongoTransactionManager(databaseFactory)
//    }
//}