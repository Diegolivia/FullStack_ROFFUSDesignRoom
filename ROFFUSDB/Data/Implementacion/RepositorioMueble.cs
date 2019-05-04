using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Entity;
using System.Configuration;
using System.Data.SqlClient;

namespace Data.Implementacion
{
    public class RepositorioMueble : IRepositorioMueble
    {
        public bool Insertar(Mueble t)
        {
            bool rpta = false;

            try
            {
                using (var conexion = new SqlConnection(ConfigurationManager.ConnectionStrings["roffusdb"].ToString()))
                {
                    conexion.Open();

                    var query = new SqlCommand("INSERT INTO Mueble VALUES(@NombreMueble)", conexion);
                    query.Parameters.AddWithValue("@NombreMueble", t.NombreMueble);

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

        public bool Actualizar(Mueble t)
        {
            bool rpta = false;

            try
            {
                using (var conexion = new SqlConnection(ConfigurationManager.ConnectionStrings["roffusdb"].ToString()))
                {
                    conexion.Open();

                    var query = new SqlCommand("UPDATE Mueble SET NombreMueble=@NombreMueble WHERE CodMueble=@CodMueble", conexion);
                    query.Parameters.AddWithValue("@CodMueble", t.CodMueble);
                    query.Parameters.AddWithValue("@NombreMueble", t.NombreMueble);

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
        public bool Eliminar(Mueble t)
        {
            bool rpta = false;

            try
            {
                using (var conexion = new SqlConnection(ConfigurationManager.ConnectionStrings["roffusdb"].ToString()))
                {
                    conexion.Open();

                    var query = new SqlCommand("DELETE Mueble WHERE CodMueble=@CodMueble", conexion);
                    query.Parameters.AddWithValue("@CodMueble", t.CodMueble);

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

        public List<Mueble> Listar()
        {
            var Muebles = new List<Mueble>();

            try
            {
                using (var conexion = new SqlConnection(ConfigurationManager.ConnectionStrings["roffusdb"].ToString()))
                {
                    conexion.Open();

                    var query = new SqlCommand("SELECT t.CodMueble,t.NombreMueble FROM Mueble t", conexion);

                    using (var dr = query.ExecuteReader())
                    {
                        while (dr.Read())
                        {
                            var Mueble = new Mueble();

                            Mueble.CodMueble = Convert.ToInt32(dr["CodMueble"]);
                            Mueble.NombreMueble = dr["NombreMueble"].ToString();

                            Muebles.Add(Mueble);
                        }
                    }

                }
            }
            catch (Exception ex)
            {
                throw;
            }
            return Muebles;
        }

        public Mueble ListarPorId(int? Id)
        {
            throw new NotImplementedException();
        }
    }
}
