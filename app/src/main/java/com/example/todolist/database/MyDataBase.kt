import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolist.database.dao.inter
import com.example.todolist.database.db
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

@Database(entities = [db::class], version = 1)
abstract class MyDataBase:RoomDatabase() {
    abstract fun inter(): inter

    companion object {
        @Volatile
        private var INSTANSE: MyDataBase? = null
        private val mutex = Mutex()

        fun get(context: Context): MyDataBase {
            if (INSTANSE != null) return INSTANSE as MyDataBase

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, MyDataBase::class.java, "notes"
                ).build()
                INSTANSE = instance
                return instance
            }
        }
    }
}
