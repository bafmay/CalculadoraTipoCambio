package com.retobcp.domain.dependencies

import com.retobcp.base.BaseDependenciesTest
import com.retobcp.core.domain.usecases.ExchangeUseCase
import org.amshove.kluent.shouldNotBeNull
import org.junit.Test
import org.koin.core.get

class UseCasesDependenciesTest : BaseDependenciesTest(){

    @Test
    fun `resolviendo dependencias para ExchangeUseCase`() {
        get<ExchangeUseCase>().shouldNotBeNull()
    }

}