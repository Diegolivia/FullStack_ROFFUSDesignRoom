using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Entity;
using Data;
using Data.Implementacion;

namespace Business.Implementacion
{
    class ServicioListaMuebles : IServicioListaMuebles
    {
        private IRepositoriolistaMuebles repositoriolistaMuebles = new RepositorioListaMuebles();
        public bool Insertar(ListaMuebles t)
        {
            return repositoriolistaMuebles.Insertar(t);
        }
        public bool Actualizar(ListaMuebles t)
        {
            return repositoriolistaMuebles.Actualizar(t);
        }
        public bool Eliminar(ListaMuebles t)
        {
            return repositoriolistaMuebles.Eliminar(t);
        }
        public List<ListaMuebles> Listar()
        {
            return repositoriolistaMuebles.Listar();
        }
        public ListaMuebles ListarporId(int? Id)
        {
            return repositoriolistaMuebles.ListarporId(Id);
        }

    }
}
