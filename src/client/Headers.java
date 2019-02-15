package client;

public class Headers {

        public String getAccept() {
            return "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8";
        }

        public String getAcceptLanguage() {
            return "Accept-Language: ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7";
        }

        public String getUserAgent() {
            return "User-Agent:" +
                    " Mozilla/5.0" +
                    " (Windows NT 10.0; Win64; x64" +
                    ") AppleWebKit/537.36" +
                    " (KHTML, like Gecko)" +
                    " Chrome/66.0.3359.139" +
                    " Safari/537.36";

        }

}