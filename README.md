# authlete-play

## Frontend

` npm create vite@latest frontend --template react`

```sh
  cd frontend
  npm install
  npm run dev
```


Nginx doesn't spin up a new thread for every request,it runs a small number of worker processes,usually one per cpu core
- Each of these workers can handle thousands of concurrent connections




The original "client credentials"" request-for-token as described in RFC 6749 looks like this:

```http
POST /token HTTP/1.1
Host: server.example.com
Authorization: Basic czZCaGRSa3F0MzpnWDFmQmF0M2JW
Content-Type: application/x-www-form-urlencoded

grant_type=client_credentials

```

... where the Authorization header contains a base64-encoded form of the client ID and the client secret, concatenated with a colon (:). If you base64-decode the above blob (czZCaGR...), you get s6BhdRkqt3:gX1fBat3bV, which would mean, for this request, the client ID is `s6BhdRkqt3` and the client secret is `gX1fBat3bV`

IETF RFC 7523 describes an alternative that relies on public/private key encryption. Instead of sending a client id+secret pair, the client sends an assertion that is signed with the client's private key.

The request for token (taken from RFC 7523) looks like so:
```http
POST /token HTTP/1.1
Host: as.example.com
Content-Type: application/x-www-form-urlencoded

grant_type=urn%3Aietf%3Aparams%3Aoauth%3Agrant-type%3Ajwt-bearer
&assertion=eyJhbGciOiJFUzI1NiIsImtpZCI6IjE2In0.
eyJpc3Mi[...omitted for brevity...].
J9l-ZhwP[...omitted for brevity...]
```

[Apigee-Sample-Jwt-Bearer-Token-Exchange?tab=readme-ov-file](https://github.com/DinoChiesa/Apigee-Sample-Jwt-Bearer-Token-Exchange?tab=readme-ov-file)

[oauth-2-0-and-openid-connect-implementation-in-c-authlete](https://darutk.medium.com/oauth-2-0-and-openid-connect-implementation-in-c-authlete-8a8f9efc9361)

[https-ssl-tls](https://www.sobyte.net/post/2021-12/https-ssl-tls/)

[whys-the-design-dns-udp-tcp](https://www.sobyte.net/post/2021-12/whys-the-design-dns-udp-tcp/)

[whys-the-design-https-latency](https://www.sobyte.net/post/2021-12/whys-the-design-https-latency/)

[golang-memory-allocator](https://www.sobyte.net/post/2021-12/golang-memory-allocator/)

[](https://www.sobyte.net/post/2021-12/whys-the-design-tcp-time-wait/)