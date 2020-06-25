package com.retobcp.domain.dependencies

import com.retobcp.base.BaseDependenciesTest
import org.koin.core.get
import com.retobcp.core.domain.repository.ExchangeRepository
import org.amshove.kluent.shouldNotBeNull
import org.junit.Test

class RepositoriesDependenciesTest : BaseDependenciesTest(){

    @Test
    fun `resolviendo dependencias para ExchangeRepository`() {
        get<ExchangeRepository>().shouldNotBeNull()
    }

}