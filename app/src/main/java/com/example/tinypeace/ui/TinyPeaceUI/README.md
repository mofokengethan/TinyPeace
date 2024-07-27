```kotlin

// DataSource.kt
interface DataSource {
    suspend fun getData(): String
}

// FakeDataSource.kt
class FakeDataSource : DataSource {
    override suspend fun getData(): String {
        return "Hello, Clean Architecture!"
    }
}

// Repository.kt
interface Repository {
    suspend fun fetchData(): String
}

// RepositoryImpl.kt
class RepositoryImpl(private val dataSource: DataSource) : Repository {
    override suspend fun fetchData(): String {
        return dataSource.getData()
    }
}
```

```kotlin
// MyViewModel.kt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel(private val repository: Repository) : ViewModel() {
    private var _data = mutableStateOf<String>("")
    val data: State<String> get() = _data

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _data.value = repository.fetchData()
        }
    }
}
```
