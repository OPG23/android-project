# 🏋️ Funcionalidades de Ryuu Fit

## Descripción General
**Ryuu Fit** es una aplicación móvil de entrenamiento físico diseñada para transformar cualquier espacio del hogar en un gimnasio personal. Ofrece rutinas personalizadas, planes de alimentación y seguimiento de progreso, todo sin necesidad de equipo profesional.

---

## 📋 Funcionalidades Principales

### 1. 🎯 Test Inicial Personalizado
Al iniciar por primera vez, el usuario completa un cuestionario interactivo dividido en dos partes:

#### **Parte 1 - Información Personal y Objetivos**
- **Datos físicos:** Edad (15-100 años), altura (100-200 cm), peso (30-200 kg)
- **Género:** Masculino, Femenino, Otro
- **Complexión corporal:** Delgada, Media, Musculosa, Robusta
- **Nivel de actividad actual:** Nunca, 1-2 veces/semana, 3-5 veces/semana, Diario
- **Condición física:** Bajo, Medio, Alto
- **Objetivo principal:** Bajar de peso, Ganar masa muscular, Mantenerme en forma, Otro
- **Tiempo disponible:** 15 min, 30 min, 45 min, 1h, Más de 1h
- **🔥 Días de entrenamiento por semana:** 1-6 días (CLAVE para personalización)
- **Restricciones alimenticias:** Ninguna, Vegetariano, Vegano, Sin gluten, Otra
- **Frecuencia de comidas rápidas:** Nunca, 1 vez/semana, 2-3 veces/semana, Más de 3 veces/semana

#### **Parte 2 - Hábitos y Preferencias**
- **Horas de sueño:** 4-12 horas
- **Motivación principal:** Salud, Estética, Rendimiento deportivo, Otro
- **Notificaciones:** Sí / No

**🎯 Funcionalidad Dinámica Automática:**
- El sistema **adapta automáticamente** las rutinas semanales según los días seleccionados
- Los datos se **guardan permanentemente** usando SharedPreferences
- El test puede **repetirse en cualquier momento** desde "Actualización de información" en el Home
- Al actualizar el test, las rutinas se **reconfiguran instantáneamente**

---

### 2. 📅 Rutinas de Entrenamiento Semanales Inteligentes

#### **Sistema de Distribución Automática**
La aplicación utiliza un algoritmo que asigna días específicos según la disponibilidad del usuario:

| Días/Semana | Días Mostrados | Enfoque |
|-------------|----------------|---------|
| **1 día**   | Lunes | Tren superior |
| **2 días**  | Lunes, Jueves | Tren superior + core |
| **3 días**  | Lunes, Miércoles, Viernes | Distribución equilibrada |
| **4 días**  | Lunes, Martes, Jueves, Viernes | Enfoque por grupos musculares |
| **5 días**  | Lunes a Viernes | Rutina split completa |
| **6 días**  | Lunes a Sábado | Máxima frecuencia con descanso dominical |

#### **Rutinas Específicas por Día**
Cada día tiene un enfoque muscular diferente para optimizar la recuperación:

- **🔴 Lunes - Pecho y Tríceps**
  - Flexiones (variantes: pared, apoyando rodillas, pica)
  - Fondos de silla
  - Flexiones contra pared
  - Estiramiento de brazos

- **🔵 Martes - Espalda y Bíceps**
  - Curl con botellas pequeñas
  - Remo con toalla
  - Superman tumbado
  - Estiramiento de brazos en cruz

- **🟢 Miércoles - Piernas y Glúteos**
  - Sentadillas parciales
  - Puente de glúteos
  - Elevación de talones
  - Marcha en sitio

- **🟡 Jueves - Hombros y Core**
  - Elevaciones laterales
  - Plancha frontal
  - Abdominales cortos
  - Plancha con antebrazos

- **🟣 Viernes - Full Body**
  - Sentadillas con extensión de brazos
  - Flexiones de pared
  - Marcha activa
  - Respiración profunda

- **🟠 Sábado - Piernas y Core**
  - Sentadillas con apoyo
  - Elevación lateral de piernas
  - Plancha con antebrazos
  - Abdominales cortos

#### **Características de las Rutinas**
- ✅ **Sin equipo:** Solo peso corporal o elementos caseros (botellas, toallas, sillas)
- ✅ **Espacios reducidos:** Adaptadas para entrenar en cualquier habitación
- ✅ **Progresión gradual:** De variantes fáciles a avanzadas
- ✅ **Imágenes demostrativas** de cada ejercicio
- ✅ **Navegación fácil** con botón "Ver más" en cada día

---

### 3. 🎯 Entrenamiento por Categorías de Objetivo

Acceso directo desde el Home a rutinas especializadas:

#### **🏃 Cardio - Quema de Calorías**
Ejercicios para mejorar la resistencia cardiovascular:
- Marcha en sitio
- Marcha activa
- Elevación de talones
- Respiración profunda
- **Beneficio:** Mejora la salud del corazón y quema grasa

#### **💪 Fuerza - Desarrollo Muscular**
Ejercicios de resistencia para tonificar:
- Flexiones (pared, apoyando rodillas, pica)
- Fondos de silla
- Curl con botellas pequeñas
- Remo con toalla
- Superman tumbado
- **Beneficio:** Aumenta la masa muscular y metabolismo

#### **🔥 Resistencia - Capacidad de Esfuerzo**
Ejercicios para aguante prolongado:
- Sentadillas (parciales, con apoyo, con extensión)
- Puente de glúteos
- Plancha frontal
- Plancha con antebrazos
- **Beneficio:** Mayor resistencia muscular y energía

#### **🧘 Elasticidad - Flexibilidad y Movilidad**
Ejercicios de estiramiento y flexibilidad:
- Estiramiento de brazos
- Estiramiento de brazos en cruz
- Flexiones de pared (estiramiento)
- Elevaciones laterales suaves
- **Beneficio:** Previene lesiones y mejora postura

---

### 4. 📖 Sistema de Detalles de Ejercicios Interactivo

Al seleccionar cualquier ejercicio, se abre una pantalla completa con:

#### **📊 Información Visual**
- **Nombre del ejercicio** destacado
- **Formato de series y repeticiones** (ej: 3x20)
- **Imagen demostrativa grande** del ejercicio
- **Logo de Ryuu Fit** como referencia de marca

#### **📝 Descripción Desplegable**
- Botón **"Ver detalles"** que expande/contrae la información
- **Descripción completa** del ejercicio con animación suave
- **Músculos trabajados** explicados
- **Beneficios específicos** del movimiento

#### **⏱️ Sistema de Series con Temporizador Automático**
Funcionalidad avanzada de seguimiento:

1. **Indicador de Serie Actual**
   - Muestra "Serie X de 3" en grande
   - Seguimiento visual del progreso

2. **Temporizador de Descanso**
   - Cuenta regresiva automática de **30 segundos**
   - Se activa al presionar "Siguiente serie"
   - Display en rojo: "Descanso: XXs"
   - **Avance automático** al terminar el tiempo

3. **Control de Flujo**
   - Botón **"Siguiente serie"** para series 1 y 2
   - Botón **"Finalizar"** para la serie 3
   - Mensaje **"Ejercicio Completado"** al terminar
   - **Regreso automático** a la pantalla anterior tras completar

4. **Experiencia Sin Interrupciones**
   - No necesitas cronómetro externo
   - Progresión automática entre series
   - Control total del ritmo de entrenamiento

---

### 5. 🥗 Plan de Alimentación General

Sistema completo de guía nutricional con opciones para cada momento del día:

#### **📋 Estructura de Comidas**

##### 🌅 **Desayuno - Energía Matinal**
Opcion balanceada para comenzar el día con energía

##### 🍎 **Merienda - Media Mañana**
Snacks saludable para mantener el metabolismo activo

##### 🍽️ **Almuerzo - Comida Principal**
Platillo complets y nutritivo para la comida del mediodía

##### 🌙 **Cena - Recuperación Nocturna**
Opcion ligera y nutritiva para la noche

##### 🥤 **Snacks Saludables**
Alternativa inteligente para controlar antojos

#### **✨ Características del Plan**
- ✅ **Imágenes de referencia** de cada platillo
- ✅ **Ingredientes principales** listados
- ✅ **Opciones adaptadas** a restricciones del test inicial
- ✅ **Variedad de alternativas** para evitar monotonía
- ✅ **Navegación fácil** entre categorías de comidas

---

### 6. 👤 Menú de Perfil y Configuración

Panel completo de gestión personal:
- **Información del usuario** editable
- **Repetir test inicial** (actualiza rutinas automáticamente)
- **Preferencias personales**
- Acceso directo desde "Actualización de información" en Home

---

### 7. 🎨 Interfaz y Experiencia de Usuario

#### **🧭 Navegación Principal**
**Barra Inferior Fija** con 4 secciones:
1. **🏠 Inicio** - Pantalla principal con acceso a todo
2. **💪 Rutinas** - Acceso directo al calendario semanal
3. **👤 Perfil** - Configuración y datos personales

#### **🏠 Pantalla de Inicio (Home)**
- **Barra de búsqueda** en la parte superior
- **Chips de acceso rápido:**
  - Avances
  - Rutinas
  - Nutrición
- **Logo central** de Ryuu Fit
- **4 Categorías circulares:**
  - Cardio (con icono)
  - Fuerza (con icono)
  - Resistencia (con icono)
  - Elasticidad (con icono)
- **2 Cards principales:**
  - Actualización de información → Test inicial
  - Opciones de dietas → Plan alimenticio

#### **🎨 Diseño Visual**
- **Tema:** Fondo negro elegante con elementos blancos
- **Acentos:** Rojo (#FF0000) para botones principales
- **Iconografía:** Clara y representativa de cada función
- **Imágenes:** Alta calidad en todos los ejercicios
- **Tipografía:** Clara y legible con diferentes pesos
- **Animaciones:** Suaves en desplegables y transiciones
