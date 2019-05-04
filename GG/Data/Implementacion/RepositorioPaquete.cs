using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Implementacion
{
   public class RepositorioPaquete : IRepositorioPaquete
    {
        public bool Insertar(Paquete t)
        {
            bool rpta = false;

            try
            {
                using (var conexion = new SqlConnection(ConfigurationManager.ConnectionStrings["roffusdb"].ToString()))
                {
                    conexion.Open();

                    var query = new SqlCommand("INSERT INTO Paquete VALUES(@NombrePaquete)", conexion);
                    query.Parameters.AddWithValue("@NombrePaquete", t.NombrePaquete);

                    query.ExecuteNonQuery();

                    rpta = true;
                }
            }
            catch (Exception ex)
            {
                throw;
            }
            return rpta;
        }

        public bool Actualizar(Paquete t)
        {
            bool rpta = false;

            try
            {
                using (var conexion = new SqlConnection(ConfigurationManager.ConnectionStrings["roffusdb"].ToString()))
                {
                    conexion.Open();

                    var query = new SqlCommand("UPDATE Paquete SET NombrePaquete=@NombrePaquete WHERE CodPaquete=@CodPaquete", conexion);
                    query.Parameters.AddWithValue("@CodPaquete", t.CodPaquete);
                    query.Parameters.AddWithValue("@NombrePaquete", t.NombrePaquete);

                    query.ExecuteNonQuery();

                    rpta = true;
                }
            }
            catch (Exception ex)
            {
                throw;
            }
            return rpta;
        }
        public bool Eliminar(Paquete t)
        {
            bool rpta = false;

            try
            {
                using (var conexion = new SqlConnection(ConfigurationManager.ConnectionStrings["roffusdb"].ToString()))
                {
                    conexion.Open();

                    var query = new SqlCommand("DELETE Paquete WHERE CodPaquete=@CodPaquete", conexion);
                    query.Parameters.AddWithValue("@CodPaquete", t.CodPaquete);

                    query.ExecuteNonQuery();

                    rpta = true;
                }
            }
            catch (Exception ex)
            {
                throw;
            }
            return rpta;
        }

        public List<Paquete> Listar()
        {
            var Paquetes = new List<Paquete>();

            try
            {
                using (var conexion = new SqlConnection(ConfigurationManager.ConnectionStrings["roffusdb"].ToString()))
                {
                    conexion.Open();

                    var query = new SqlCommand("SELECT t.CodPaquete,t.NombrePaquete FROM Paquete t", conexion);

                    using (var dr = query.ExecuteReader())
                    {
                        while (dr.Read())
                        {
                            var Paquete = new Paquete();

                            Paquete.CodPaquete = Convert.ToInt32(dr["CodPaquete"]);
                            Paquete.NombrePaquete = dr["NombrePaquete"].ToString();

                            Paquetes.Add(Paquete);
                        }
                    }

                }
            }
            catch (Exception ex)
            {
                throw;
            }
            return Paquetes;
        }

        public Paquete ListarPorId(int? Id)
        {
            throw new NotImplementedException();
        }
    }
}
