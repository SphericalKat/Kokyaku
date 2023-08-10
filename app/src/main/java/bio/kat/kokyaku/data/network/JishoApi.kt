package bio.kat.kokyaku.data.network

import androidx.annotation.Keep
import com.slack.eithernet.ApiResult
import retrofit2.http.GET
import retrofit2.http.Query

@Keep
interface JishoApi {
    @GET("search/words")
    suspend fun words(
        @Query("keyword") keyword: String
    ): ApiResult<>
}