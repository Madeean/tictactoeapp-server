package example.com.repositories.history

import example.com.repositories.history.model.HistoryDraft
import example.com.repositories.history.model.HistoryModel

interface HistoryRepository {
    fun getAllProducts() : List<HistoryModel>
    fun getProduct(id: Int): HistoryModel?
    fun addHistory(draft: HistoryDraft): HistoryModel
}