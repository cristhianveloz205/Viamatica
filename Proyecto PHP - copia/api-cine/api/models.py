from django.db import models

class SalaCine(models.Model):
    id_sala = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=100)
    estado = models.BooleanField(default=True)

    class Meta:
        db_table = 'sala_cine'

class Pelicula(models.Model):
    id_pelicula = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=255)
    duracion = models.IntegerField(help_text="Duración en minutos")
    estado_logico = models.BooleanField(default=True) 

    class Meta:
        db_table = 'pelicula'

class PeliculaSalaCine(models.Model):
    id_pelicula_sala = models.AutoField(primary_key=True)
    id_sala_cine = models.ForeignKey(SalaCine, on_delete=models.CASCADE, db_column='id_sala_cine')
    id_pelicula = models.ForeignKey(Pelicula, on_delete=models.CASCADE, db_column='id_pelicula')
    fecha_publicacion = models.DateField()
    fecha_fin = models.DateField()

    class Meta:

        db_table = 'pelicula_salacine'
