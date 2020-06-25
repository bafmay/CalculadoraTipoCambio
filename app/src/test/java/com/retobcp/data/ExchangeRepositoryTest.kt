@file:Suppress("EXPERIMENTAL_API_USAGE")
package com.retobcp.data

import com.retobcp.core.data.repository.ExchangeDataRepository
import com.retobcp.core.data.repository.cloud.ExchangeCloudStore
import com.retobcp.core.data.repository.data.ExchangeDataStore
import com.retobcp.core.data.repository.mapper.ExchangeMapper
import com.retobcp.core.domain.repository.ExchangeRepository
import com.retobcp.utils.RetoBCPMock
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldHaveSize
import org.junit.Before
import org.junit.Test

class ExchangeRepositoryTest {

    private val cloudStoreMock = mockk<ExchangeCloudStore>()
    private val dataStoreMock = mockk<ExchangeDataStore>()
    private val mapper = ExchangeMapper()

    private lateinit var exchangeRepository: ExchangeRepository

    @Before
    fun setup() {
        exchangeRepository = ExchangeDataRepository(cloudStoreMock, dataStoreMock, mapper)
    }

    @Test
    fun `test getExchangeRates`() = runBlockingTest {
        val dataMock =
            ExchangeMockHelper.getItems(RetoBCPMock.currency1,RetoBCPMock.currency2)
        coEvery { dataStoreMock.getExchangesList(any(),any()) } returns dataMock
        val items = exchangeRepository.getExchangeRates(RetoBCPMock.currency1,RetoBCPMock.currency2)
        items shouldHaveSize 2
    }

    @Test
    fun `test getExchange`() = runBlockingTest {
        val dataMock =
            ExchangeMockHelper.getCurrencyItem(RetoBCPMock.currency1,RetoBCPMock.currency2)
        coEvery { dataStoreMock.getExchange(any(),any()) } returns dataMock
        val items = exchangeRepository.getExchange(RetoBCPMock.currency1,RetoBCPMock.currency2)
        items shouldHaveSize 1
    }

}