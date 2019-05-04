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
    public class RepositorioListaMueble : IRepositorioListaMueble
    {
        public bool Insertar(ListaMueble t)
        {
            bool rpta = false;

            try
            {
                using (var conexion = new SqlConnection(ConfigurationManager.ConnectionStrings["roffusdb"].ToString()))
                {
                    conexion.Open();

                    var query = new SqlCommand("INSERT INTO ListaMueble VALUES(@NombreListaMueble)", conexion);
                    query.Parameters.AddWithValue("@NombreListaMueble", t.NombreListaMueble);

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

        public bool Actualizar(ListaMueble t)
        {
            bool rpta = false;

            try
            {
                using (var conexion = new SqlConnection(ConfigurationManager.ConnectionStrings["roffusdb"].ToString()))
                {
                    conexion.Open();

                    var query = new SqlCommand("UPDATE ListaMueble SET NombreListaMueble=@NombreListaMueble WHERE CodListaMueble=@CodListaMueble", conexion);
                    query.Parameters.AddWithValue("@CodListaMueble", t.CodListaMueble);
                    query.Parameters.AddWithValue("@NombreListaMueble", t.NombreListaMueble);

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
        public bool Eliminar(ListaMueble t)
        {
            bool rpta = false;

            try
            {
                using (var conexion = new SqlConnection(ConfigurationManager.ConnectionStrings["roffusdb"].ToString()))
                {
                    conexion.Open();

                    var query = new SqlCommand("DELETE ListaMueble WHERE CodListaMueble=@CodListaMueble", conexion);
                    query.Parameters.AddWithValue("@CodListaMueble", t.CodListaMueble);

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

        public List<ListaMueble> Listar()
        {
            var ListaMuebles = new List<ListaMueble>();

            try
            {
                using (var conexion = new SqlConnection(ConfigurationManager.ConnectionStrings["roffusdb"].ToString()))
                {
                    conexion.Open();

                    var query = new SqlCommand("SELECT t.CodListaMueble,t.NombreListaMueble FROM ListaMueble t", conexion);

                    using (var dr = query.ExecuteReader())
                    {
                        while (dr.Read())
                        {
                            var ListaMueble = new ListaMueble();

                            ListaMueble.CodListaMueble = Convert.ToInt32(dr["CodListaMueble"]);
                            ListaMueble.NombreListaMueble = dr["NombreListaMueble"].ToString();

                            ListaMuebles.Add(ListaMueble);
                        }
                    }

                }
            }
            catch (Exception ex)
            {
                throw;
            }
            return ListaMuebles;
        }

        public ListaMueble ListarPorId(int? Id)
        {
            throw new NotImplementedException();
        }
    }
}
