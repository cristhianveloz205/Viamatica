from .repository import PeliculaRepository

class PeliculaService:

    @staticmethod
    def listar():
        return PeliculaRepository.get_all()

    @staticmethod
    def obtener(id_p):
        return PeliculaRepository.get_by_id(id_p)

    @staticmethod
    def crear(data):
        return PeliculaRepository.create(data)

    @staticmethod
    def actualizar(id_p, data):
        pelicula = PeliculaRepository.get_by_id(id_p)
        if not pelicula:
            return None
        return PeliculaRepository.update(pelicula, data)

    @staticmethod
    def eliminar(id_p):
        pelicula = PeliculaRepository.get_by_id(id_p)
        if not pelicula:
            return False
        return PeliculaRepository.logical_delete(pelicula)