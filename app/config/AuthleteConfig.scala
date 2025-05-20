package config

final case class AuthleteConfig(
    apiKey: String,
    apiSecret: String,
    baseUrl: String = "https://us.authlete.com",
    apiVersion: String = "V3",
    serviceApiKey: String,
    serviceAccessToken: String,
    serviceApiSecret: String
)
