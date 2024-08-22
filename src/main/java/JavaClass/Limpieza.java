package JavaClass;


public class Limpieza extends Producto  {
        protected String tipoAplic;  //COCINA - BAÑO - ROPA - MULTIUSO

        public Limpieza(String id, String descripcion, double precioPorUnid,
                        double porcentajeGanancia, boolean isDisponible, boolean isImportado,
                        int calorias, String tipoEnv, int cantStock, String tipoAplic) {
                this.id = id;
                this.descripcion = descripcion;
                this.precioPorUnid = precioPorUnid;
                this.porcentajeGanancia = porcentajeGanancia;
                this.isDisponible = isDisponible;
                this.isImportado = isImportado;
                this.calorias = calorias;
                this.tipoEnv = tipoEnv;
                this.cantStock = cantStock;
                this.tipoAplic = tipoAplic;
        }

        public String getTipoAplic() {
                return tipoAplic;
        }

        public void setTipoAplic(String tipoAplic) {
                this.tipoAplic = tipoAplic;
        }


}






