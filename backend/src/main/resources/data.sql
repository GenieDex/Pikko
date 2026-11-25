INSERT INTO usuarios (nombre_usuario, email, password_hash, rol, fecha_registro)
VALUES ('pikko', 'admin@pikko.local', '$2a$10$83Tb6FV32nsU3I1./MZxJ.SwEusVJCc/KTOlJ0qzC/N94HqS2OGkm', 'ADMIN', NOW())
ON CONFLICT (nombre_usuario) DO NOTHING;

INSERT INTO retos (titulo, descripcion, categoria, tipo_prueba, 
                    estado_moderacion, fecha_inicio, fecha_fin, fecha_creacion, creador_id)
SELECT '30 días de yoga',
       'Practica al menos 15 minutos de yoga cada día durante un mes.',
       'BIENESTAR', 'AUTODECLARADO', 'APROBADO',
       CURRENT_DATE, CURRENT_DATE + 30, NOW(), id
FROM usuarios
WHERE nombre_usuario = 'pikko'
  AND NOT EXISTS (SELECT 1 FROM retos WHERE titulo = '30 días de yoga');

INSERT INTO retos (titulo, descripcion, categoria, tipo_prueba, 
                    estado_moderacion, fecha_inicio, fecha_fin, fecha_creacion, creador_id)
SELECT 'Comida sana una semana',
       'Cocina y come sano durante una semana. Recuerda: ¡Platos coloridos!',
       'ALIMENTACION', 'AUTODECLARADO', 'APROBADO',
       CURRENT_DATE, CURRENT_DATE + 7, NOW(), id
FROM usuarios
WHERE nombre_usuario = 'pikko'
  AND NOT EXISTS (SELECT 1 FROM retos WHERE titulo = 'Comida sana una semana');

INSERT INTO retos (titulo, descripcion, categoria, tipo_prueba, 
                    estado_moderacion, fecha_inicio, fecha_fin, fecha_creacion, creador_id)
SELECT 'Muévete del sofá',
       'Sal a hacer deporte cinco días seguidos. Vale cualquier cosa: caminar, correr, ir en bici... ¡Pero el "sofing" no cuenta!',
       'DEPORTE', 'AUTODECLARADO', 'APROBADO',
       CURRENT_DATE, CURRENT_DATE + 5, NOW(), id
FROM usuarios
WHERE nombre_usuario = 'pikko'
  AND NOT EXISTS (SELECT 1 FROM retos WHERE titulo = 'Muévete del sofá');

INSERT INTO retos (titulo, descripcion, categoria, tipo_prueba, 
                    estado_moderacion, fecha_inicio, fecha_fin, fecha_creacion, creador_id)
SELECT 'Nada de TikTok',
       '¿Eres capaz de estar una semana sin redes sociales? ¡Demuéstralo! Bloquea o elimina las redes de tu móvil durante una semana.',
       'DESCONEXION', 'AUTODECLARADO', 'APROBADO',
       CURRENT_DATE, CURRENT_DATE + 7, NOW(), id
FROM usuarios
WHERE nombre_usuario = 'pikko'
  AND NOT EXISTS (SELECT 1 FROM retos WHERE titulo = 'Nada de TikTok');

INSERT INTO retos (titulo, descripcion, categoria, tipo_prueba, 
                    estado_moderacion, fecha_inicio, fecha_fin, fecha_creacion, creador_id)
SELECT 'Dos meses de código',
       '¡Programa algo todos los días durante dos meses! Aprende un nuevo lenguaje o lleva a cabo tus proyectos.',
       'APRENDIZAJE', 'AUTODECLARADO', 'APROBADO',
       CURRENT_DATE, CURRENT_DATE + 60, NOW(), id
FROM usuarios
WHERE nombre_usuario = 'pikko'
  AND NOT EXISTS (SELECT 1 FROM retos WHERE titulo = 'Dos meses de código');

INSERT INTO retos (titulo, descripcion, categoria, tipo_prueba, 
                    estado_moderacion, fecha_inicio, fecha_fin, fecha_creacion, creador_id)
SELECT 'Saca tu Mozart interior',
       'Compón una canción y grábala. Puedes usar el instrumento que quieras, o tu voz si no dominas ninguno. Y si no te fías de eso tampoco, puedes atreverte a rapear.',
       'CREATIVIDAD', 'AUTODECLARADO', 'APROBADO',
       CURRENT_DATE, CURRENT_DATE + 60, NOW(), id
FROM usuarios
WHERE nombre_usuario = 'pikko'
  AND NOT EXISTS (SELECT 1 FROM retos WHERE titulo = 'Saca tu Mozart interior');

  
INSERT INTO retos (titulo, descripcion, categoria, tipo_prueba, 
                    estado_moderacion, fecha_inicio, fecha_fin, fecha_creacion, creador_id)
SELECT 'Todo por las patitas',
       'Ayuda de forma voluntaria en una protectora animal. ¡Siempre necesitan ayuda! Tienes 20 días para apuntarte, y ayudar al menos una vez.',
       'SOCIAL', 'AUTODECLARADO', 'APROBADO',
       CURRENT_DATE, CURRENT_DATE + 20, NOW(), id
FROM usuarios
WHERE nombre_usuario = 'pikko'
  AND NOT EXISTS (SELECT 1 FROM retos WHERE titulo = 'Todo por las patitas');