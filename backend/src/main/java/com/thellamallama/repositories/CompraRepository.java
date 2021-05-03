package com.thellamallama.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thellamallama.entities.Compra;
import com.thellamallama.entities.Cliente;
import com.thellamallama.entities.Tienda;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    Optional<Compra> findById(Long id);

    @Query("SELECT c FROM Compra c WHERE c.cliente=?1") //encontrar todas las compras de un cliente
    List<Compra> findComprasPorCliente(Cliente cliente);

    @Query("SELECT c FROM Compra c WHERE c.fecha=?1") //encontrar las compras de una fecha especifica
    List<Compra> findComprasPorFecha(Date fecha);

    @Query(value = "SELECT c.id, T.id, T.nombre, P.id, p.nombre, c.cliente_id FROM compra c " +
            "JOIN Producto P ON P.compra_producto = c.id " +
            "JOIN tiendas T ON T.id = P.tienda_producto" +
            "WHERE c.fecha=:inputFecha", nativeQuery = true
    ) //encontrar las compras de una tienda especifica
    List<Compra> findComprasPorTienda(
            @Param("inputFecha") Date fecha
    );
    @Query(value = "SELECT c.id, c.cliente_id, c.monto_total, c.monto_total-c.monto_total*Tp.descuento FROM compra c" +
            "JOIN Tipo_pago Tp ON c.tipo_pago_id = Tp.id" +
            "WHERE c.id=:codigoCompra",
            nativeQuery = true
    ) // aplicar descuento a una compra
    Optional<Compra> applyDiscount(
            @Param("codigoCompra") Long id
    );
}
