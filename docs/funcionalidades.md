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
- Los datos se **guardan permanentemente** usando SharedPreferences (persistencia local)
- El test puede **repetirse en cualquier momento** desde "Actualización de información" en el Home
- Al actualizar el test, las rutinas se **reconfiguran instantáneamente**
- **Todos los campos del test** se guardan y están disponibles en el perfil del usuario

---

### 2. 📅 Rutinas de Entrenamiento Semanales Inteligentes

#### **Sistema de Distribución Automática**
La aplicación utiliza un algoritmo que asigna días específicos según la disponibilidad del usuario:

| Días/Semana | Días Mostrados | Enfoque |
|-------------|----------------|---------|
| **1 día**   | Lunes | Tren superior |
| **2 días**  | Lunes, Jueves | Tren superior + Tren inferior |
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
- ✅ **Visualización dinámica:** Solo se muestran los días según tu disponibilidad

---

### 3. 🎯 Entrenamiento por Categorías de Objetivo

Acceso directo desde el Home a rutinas especializadas con **navegación completa y funcional**:

#### **🏃 Cardio - Quema de Calorías**
Ejercicios para mejorar la resistencia cardiovascular:
- Jumping Jacks (3×45 seg)
- Burpees (4×15 rep)
- High Knees (3×40 seg)
- Mountain Climbers (3×30 seg)
- Sprints en el Lugar (4×30 seg)
- **Beneficio:** Mejora la salud del corazón y quema grasa

#### **💪 Fuerza - Desarrollo Muscular**
Ejercicios de resistencia para tonificar:
- Flexiones de Pecho (Push-Ups) (4×15 rep)
- Sentadillas (Squats) (4×20 rep)
- Zancadas (Lunges) (3×12 rep por pierna)
- Planchas (Planks) (3×45 seg)
- Fondos entre Sillas (Triceps Dips) (3×12 rep)
- **Beneficio:** Aumenta la masa muscular y metabolismo

#### **🔥 Resistencia - Capacidad de Esfuerzo**
Ejercicios para aguante prolongado:
- Plancha Dinámica (3×45 seg)
- Escaladores (Mountain Climbers) (4×30 seg)
- Saltos Laterales (3×40 seg)
- Sentadilla Isométrica (3×40 seg)
- Trote Estático (5×1 min)
- **Beneficio:** Mayor resistencia muscular y energía

#### **🧘 Elasticidad - Flexibilidad y Movilidad**
Ejercicios de estiramiento y flexibilidad:
- Estiramiento de Espalda y Brazos (3×30 seg)
- Estiramiento de Piernas Sentado (3×30 seg)
- Giro de Tronco de Pie (3×20)
- Rotación de Caderas (3×20)
- Perro Boca Abajo (Yoga) (3×40 seg)
- **Beneficio:** Previene lesiones y mejora postura

**✨ Características de las Categorías:**
- ✅ Checkboxes interactivos para marcar ejercicios completados
- ✅ Imágenes representativas de cada ejercicio
- ✅ Series y repeticiones claramente especificadas
- ✅ Botón "Finalizar entrenamiento" que regresa al Home
- ✅ Navegación fluida sin errores

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
Opción balanceada para comenzar el día con energía

##### 🍎 **Merienda - Media Mañana**
Snack saludable para mantener el metabolismo activo

##### 🍽️ **Almuerzo - Comida Principal**
Platillo completo y nutritivo para la comida del mediodía

##### 🌙 **Cena - Recuperación Nocturna**
Opción ligera y nutritiva para la noche

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

Panel completo de gestión personal con **información dinámica del test inicial**:

#### **📊 Datos del Usuario Mostrados:**
- **Peso actual y objetivo principal** (ej: "Peso Actual: 70 Kg • Objetivo: Ganar masa muscular")
- **Días de entrenamiento semanales** con representación visual (ej: "L M M J V")
- **Tiempo disponible para ejercicio** (ej: "45 min")
- **Edad y nivel de condición física** (ej: "Edad: 25 años • Nivel: Medio")

#### **⚠️ Sistema de Alertas:**
- Si el usuario **no ha completado el test inicial**, muestra mensaje de advertencia
- Botón directo **"Hacer Test Inicial"** para completar el perfil
- Cards solo se muestran si hay datos disponibles

#### **🔄 Funcionalidades del Perfil:**
- **Botón "Actualizar Información"** para repetir el test
- Acceso rápido a **Rutina Semanal** y **Plan Alimenticio**
- **Datos sincronizados** en tiempo real con el test inicial
- Botón "Volver" para regresar al Home

---

### 7. 🎨 Interfaz y Experiencia de Usuario

#### **🧭 Navegación Principal**
**Barra Inferior Fija** con 3 secciones:
1. **🏠 Inicio** - Pantalla principal con acceso a todo
2. **💪 Rutinas** - Acceso directo al calendario semanal
3. **👤 Perfil** - Configuración y datos personales

#### **🏠 Pantalla de Inicio (Home) - Simplificada**
- **2 Chips de acceso rápido:**
  - Rutinas
  - Nutrición
- **Logo central** de Ryuu Fit (tamaño ampliado)
- **4 Categorías circulares:**
  - Cardio (con icono representativo)
  - Fuerza (con icono representativo)
  - Resistencia (con icono representativo)
  - Elasticidad (con icono representativo)
- **2 Cards principales:**
  - Actualización de información → Test inicial
  - Opciones de dietas → Plan alimenticio

#### **🎨 Diseño Visual**
- **Tema:** Fondo negro elegante con elementos blancos
- **Acentos:** Rojo (#FF0000) para botones principales y elementos destacados
- **Iconografía:** Clara y representativa de cada función
- **Imágenes:** Alta calidad en todos los ejercicios
- **Tipografía:** Clara y legible con diferentes pesos (Bold para títulos)
- **Animaciones:** Suaves en desplegables y transiciones
- **Interfaz limpia:** Elementos innecesarios eliminados para mejor experiencia

---

## 🎯 Ventajas Competitivas

### 💡 **Personalización Inteligente**
- Rutinas que se adaptan automáticamente a tu disponibilidad
- Perfil dinámico que muestra tus datos en tiempo real
- No más planes genéricos que no sigues

### 🏠 **Entrena Donde Quieras**
- Cero excusas: tu casa es tu gimnasio
- Sin inversión en equipo costoso
- Espacios reducidos no son problema

### ⏱️ **Temporizador Integrado**
- No necesitas apps adicionales
- Descansos automáticos entre series (30 segundos)
- Progresión sin interrupciones

### 📱 **Todo en Uno**
- Entrenamiento + Nutrición + Seguimiento
- Una sola app para tu transformación completa
- Navegación fluida entre todas las funcionalidades

### 🔄 **Actualización Continua**
- Repite el test cuando cambien tus circunstancias
- Plan que evoluciona contigo
- Datos sincronizados automáticamente

### 👥 **Accesibilidad Total**
- Para todos los niveles: principiante a avanzado
- Interfaz intuitiva y fácil de usar
- Sin curva de aprendizaje complicada

---

## 🛠️ Especificaciones Técnicas

### **Plataforma y Desarrollo**
- **Sistema Operativo:** Android 8.0+ (API 26+)
- **Lenguaje:** Kotlin
- **Framework UI:** Jetpack Compose (UI moderna y declarativa)
- **Arquitectura:** MVVM (Model-View-ViewModel)
- **Navegación:** Navigation Component con rutas type-safe
- **Gestión de Estado:** StateFlow para datos reactivos

### **Características Técnicas**
- **Persistencia de Datos:** SharedPreferences para configuraciones de usuario
- **ViewModel Compartido:** Sincronización automática entre pantallas
- **Temporizador:** Coroutines con LaunchedEffect para descansos automáticos
- **Animaciones:** AnimatedVisibility para transiciones suaves
- **Modo Offline:** Funciona completamente sin internet
- **Tamaño:** Ligera y optimizada para dispositivos de gama media

### **Almacenamiento de Datos**
El sistema guarda de forma permanente:
- Todos los datos del test inicial (15 campos)
- Preferencias de usuario
- Configuración de la app
- Datos recuperables incluso después de cerrar la app

---

## 📈 Flujo de Usuario Típico

1. **Primera Vez:**
   - Login → Test Inicial (2 partes con 15 preguntas) → Home → Explorar rutinas

2. **Uso Diario:**
   - Home → Rutinas → Seleccionar día → Ver ejercicio → Realizar con temporizador
   - O: Home → Categoría (Cardio/Fuerza/etc.) → Ejercicios específicos

3. **Actualización:**
   - Home → "Actualización de información" → Repetir test → Nuevas rutinas cargadas automáticamente
   - Perfil → Ver datos actualizados inmediatamente

4. **Exploración Libre:**
   - Home → Categorías (Cardio/Fuerza/Resistencia/Elasticidad) → Ejercicios con checkboxes

---

## 📝 Notas de Versión Actual

### ✅ **Implementado**
- ✔️ Sistema completo de test inicial con 15 preguntas
- ✔️ Algoritmo de distribución inteligente de rutinas (1-6 días)
- ✔️ Persistencia de datos con SharedPreferences
- ✔️ 40+ pantallas de ejercicios individuales
- ✔️ Temporizador de 30s entre series con avance automático
- ✔️ Sistema de series (3x por ejercicio)
- ✔️ Navegación completa entre todas las secciones
- ✔️ 4 Categorías de ejercicios (Cardio, Fuerza, Resistencia, Elasticidad)
- ✔️ Checkboxes interactivos en rutinas de categorías
- ✔️ Plan de alimentación con 5 categorías de comidas
- ✔️ Menú de perfil con datos dinámicos del test
- ✔️ Interfaz con tema oscuro profesional
- ✔️ Home simplificado y optimizado

### 🔄 **En Desarrollo / Mejoras Futuras**
- 🔨 Sistema de progreso con gráficas y estadísticas
- 🔨 Notificaciones programables personalizadas
- 🔨 Más variedad de ejercicios por categoría
- 🔨 Videos demostrativos de ejercicios
- 🔨 Integración con wearables (smartwatches)
- 🔨 Desafíos y sistema de logros

---

## 🌟 Conclusión

**Ryuu Fit** es más que una aplicación de ejercicios: es un **sistema completo de transformación física** que se adapta a tu vida, no al revés. Con su algoritmo inteligente de personalización, temporizador integrado, perfil dinámico y diseño intuitivo, elimina todas las barreras para mantener una vida activa y saludable.

**Tu gimnasio personal, donde quieras, cuando quieras** 🐉💪

---

**Desarrollado con ❤️ usando Kotlin + Jetpack Compose**
