from django.urls import path
from .controllers import PeliculaController, PeliculaDetalleController

urlpatterns = [
    path('peliculas/', PeliculaController.as_view()),
    path('peliculas/<int:pk>/', PeliculaDetalleController.as_view()),
]