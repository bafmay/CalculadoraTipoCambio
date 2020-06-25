package com.retobcp.core.data.network.di

import com.retobcp.core.data.network.RetoBCPApi
import com.retobcp.core.data.utils.createOkHttpClient
import com.retobcp.core.data.utils.createRetrofitNew
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

const val NAMED_RETO_BCP = "RETO_BCP"
const val NAMED_RETO_BCP_CLIENT = "RETO_BCP_CLIENT"

internal val networkModule = module {
    single(named(NAMED_RETO_BCP_CLIENT)) { createOkHttpClient() }
    single(named(NAMED_RETO_BCP)) { retrofitRetoBCP(get(named(NAMED_RETO_BCP_CLIENT))) }
    single { provideRetoBCPApi(get(named(NAMED_RETO_BCP))) }
}

private fun retrofitRetoBCP(okHttpClient: OkHttpClient): Retrofit {
    return createRetrofitNew(okHttpClient, "https://flutterws-bc478.firebaseio.com/")
}

private fun provideRetoBCPApi(retrofit: Retrofit): RetoBCPApi{
    return retrofit.create(RetoBCPApi::class.java)
}
