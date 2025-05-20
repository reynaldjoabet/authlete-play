package config
// ad{
//     base_url = "https://cibasim.authlete.com"
//     base_url = ${?AUTHLETE_AD_BASE_URL}

//     workspace = ${?AUTHLETE_AD_WORKSPACE}
//     mode="SYNC"
//     mode = ${?AUTHLETE_AD_MODE}
//     sync{
//     connection_timeout = 10000 # 10000 milliseconds.
//     connect_timeout = ${?AUTHLETE_AD_SYNC_CONNECT_TIMEOUT}
//     read_timeout=100 # 10000 milliseconds.
//     additional_read_timeout = ${?AUTHLETE_AD_SYNC_ADDITIONAL_READ_TIMEOUT}
//     }
//     async{
//     connect_timeout=10000 # 10000 milliseconds.
//     connect_timeout = ${?AUTHLETE_AD_ASYNC_CONNECT_TIMEOUT}
//     read_timeout=10000 # 10000 milliseconds.
//     read_timeout = ${?AUTHLETE_AD_ASYNC_READ_TIMEOUT}
//     }
//     poll{
//     connect_timeout=10000 # 10000 milliseconds.
//     connect_timeout = ${?AUTHLETE_AD_POLL_CONNECT_TIMEOUT}
//     read_timeout=10000 # 10000 milliseconds.
//     read_timeout = ${?AUTHLETE_AD_POLL_READ_TIMEOUT}
//     }
//     result{
//     connect_timeout=10000 # 10000 milliseconds.
//     connect_timeout = ${?AUTHLETE_AD_POLL_RESULT_CONNECT_TIMEOUT}
//     read_timeout=10000 # 10000 milliseconds.
//     read_timeout = ${?AUTHLETE_AD_POLL_RESULT_READ_TIMEOUT}
//     }

//     max_count=10
//     max_count = ${?AUTHLETE_AD_POLL_MAX_COUNT}
//     interval=5000 # 5000 milliseconds.
//     interval = ${?AUTHLETE_AD_POLL_INTERVAL}

//     auth_timeout_ratio=0.8
//     auth_timeout_ratio = ${?AUTHLETE_AD_AUTH_TIMEOUT_RATIO}

//     }

final case class AuthenticationDevice(
    baseUrl: String,
    workspace: String,
    // mode:Mode,
    maxCount: Int,
    interval: Int,
    authTimeoutRatio: Int
)

// enum Mode{

// }
