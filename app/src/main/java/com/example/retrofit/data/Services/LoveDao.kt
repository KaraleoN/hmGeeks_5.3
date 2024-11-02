import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retrofit.data.model.PercentageModel

@Dao
interface LoveDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(percentageModel: PercentageModel)

    @Query("SELECT * FROM percentage_model ORDER BY firstName ASC")
    suspend fun getAllResults(): List<PercentageModel>
}