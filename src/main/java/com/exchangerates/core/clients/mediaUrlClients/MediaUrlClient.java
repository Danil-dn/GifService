package com.exchangerates.core.clients.mediaUrlClients;

import com.exchangerates.core.clients.DownloadingGifInterface;
import org.springframework.cloud.openfeign.FeignClient;

class MediaUrlClient {

    @FeignClient(name = "media0", url = "https://media0.giphy.com", qualifier = "media0")
    interface MediaUrlClient0 extends DownloadingGifInterface {
    }

    @FeignClient(name = "media1", url = "https://media1.giphy.com", qualifier = "media1")
    interface MediaUrlClient1 extends DownloadingGifInterface {
    }

    @FeignClient(name = "media2", url = "https://media2.giphy.com", qualifier = "media2")
    interface MediaUrlClient2 extends DownloadingGifInterface {
    }

    @FeignClient(name = "media3", url = "https://media3.giphy.com", qualifier = "media3")
    interface MediaUrlClient3 extends DownloadingGifInterface {
    }

    @FeignClient(name = "media4", url = "https://media4.giphy.com", qualifier = "media4")
    interface MediaUrlClient4 extends DownloadingGifInterface {
    }
}