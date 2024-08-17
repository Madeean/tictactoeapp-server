package example.com.repositories.history

import example.com.repositories.history.model.HistoryDraft
import example.com.repositories.history.model.HistoryModel

class HistoryRepositoryImpl: HistoryRepository {
    private val todos: MutableList<HistoryModel> = mutableListOf()

    override fun getAllProducts(): List<HistoryModel> {
        return todos
    }

    override fun getProduct(id: Int): HistoryModel? {
        return todos.firstOrNull {
            it.id == id
        }
    }

    override fun addHistory(draft: HistoryDraft): HistoryModel {
        val history = HistoryModel(
            id = todos.size + 1,
            title = draft.title,
            dateTime = draft.dateTime
        )
        todos.add(history)
        return history
    }
}