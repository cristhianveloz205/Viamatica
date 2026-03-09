from django.shortcuts import render, redirect
from .models import Pelicula


def dashboard(request):


    if request.method == "POST" and "crear" in request.POST:
        nombre = request.POST.get("nombre")
        duracion = request.POST.get("duracion")

        if nombre and duracion:
            Pelicula.objects.create(
                nombre=nombre,
                duracion=int(duracion)
            )

        return redirect("/")

  
    if request.method == "POST" and "editar" in request.POST:
        id_p = request.POST.get("id_pelicula")
        nombre = request.POST.get("nombre")
        duracion = request.POST.get("duracion")

        pelicula = Pelicula.objects.filter(id_pelicula=id_p).first()
        if pelicula:
            pelicula.nombre = nombre
            pelicula.duracion = int(duracion)
            pelicula.save()

        return redirect("/")

 
    if request.method == "POST" and "eliminar" in request.POST:
        id_p = request.POST.get("id_pelicula")

        pelicula = Pelicula.objects.filter(id_pelicula=id_p).first()
        if pelicula:
            pelicula.estado_logico = False
            pelicula.save()

        return redirect("/")

    peliculas = Pelicula.objects.filter(estado_logico=True)

    return render(request, "api/dashboard.html", {
        "peliculas": peliculas

    })
