from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from .services import PeliculaService
from .models import Pelicula


class PeliculaController(APIView):

    def get(self, request):
        peliculas = PeliculaService.listar()
        data = [
            {
                "id": p.id_pelicula,
                "nombre": p.nombre,
                "duracion": p.duracion
            }
            for p in peliculas
        ]
        return Response(data)

    def post(self, request):
        pelicula = PeliculaService.crear(request.data)
        return Response({
            "id": pelicula.id_pelicula,
            "mensaje": "Película creada"
        }, status=201)


class PeliculaDetalleController(APIView):

    def get(self, request, pk):
        pelicula = PeliculaService.obtener(pk)
        if not pelicula:
            return Response({"error": "No encontrada"}, status=404)

        return Response({
            "id": pelicula.id_pelicula,
            "nombre": pelicula.nombre,
            "duracion": pelicula.duracion
        })

    def put(self, request, pk):
        pelicula = PeliculaService.actualizar(pk, request.data)
        if not pelicula:
            return Response({"error": "No encontrada"}, status=404)

        return Response({
            "mensaje": "Película actualizada correctamente"
        })

    def delete(self, request, pk):
        eliminado = PeliculaService.eliminar(pk)
        if not eliminado:
            return Response({"error": "No encontrada"}, status=404)

        return Response({
            "mensaje": "Película eliminada correctamente"
        })