from django.contrib import admin
from .models import Pelicula

# Configuración estética del Panel de Películas
@admin.register(Pelicula)
class PeliculaAdmin(admin.ModelAdmin):
    # Solo mostramos lo importante para que se vea limpio
    list_display = ('nombre', 'duracion') 
    
    # Añadimos un buscador por si tienes muchas películas
    search_fields = ('nombre',)
    
    # Ordenar automáticamente por nombre
    ordering = ('nombre',)

    # Diseño minimalista: solo 10 por página
    list_per_page = 10