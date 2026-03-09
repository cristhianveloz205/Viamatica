from django.contrib import admin
from .models import Pelicula

@admin.register(Pelicula)
class PeliculaAdmin(admin.ModelAdmin):
    list_display = ('nombre', 'duracion') 
    
    search_fields = ('nombre',)
    
    ordering = ('nombre',)
    list_per_page = 10
