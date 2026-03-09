from .models import Pelicula

class PeliculaRepository:

    @staticmethod
    def get_all():
        return Pelicula.objects.filter(estado_logico=True)

    @staticmethod
    def get_by_id(id_p):
        try:
            return Pelicula.objects.get(id_pelicula=id_p, estado_logico=True)
        except Pelicula.DoesNotExist:
            return None

    @staticmethod
    def create(data):
        return Pelicula.objects.create(**data)

    @staticmethod
    def update(instance, data):
        instance.nombre = data.get("nombre", instance.nombre)
        instance.duracion = data.get("duracion", instance.duracion)
        instance.save()
        return instance

    @staticmethod
    def logical_delete(instance):
        instance.estado_logico = False
        instance.save()
        return True