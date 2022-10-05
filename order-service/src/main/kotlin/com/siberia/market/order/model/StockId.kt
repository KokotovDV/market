import com.siberia.market.order.model.DocumentType
import com.siberia.market.order.model.Product
import com.siberia.market.order.model.Warehouse
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Id

data class StockId (
    @Id
    val registrationDate: LocalDateTime,

    @Id
    val documentType: DocumentType,

    @Id
    val documentId: String,

    @Id
    val warehouse: Warehouse,

    @Id
    val product: Product
) : Serializable