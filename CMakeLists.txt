# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

SET( CMAKE_WARN_DEPRECATED 0)
SET(SOURCE_CPP_DIR cpp)
SET(SOURCE_GBM_DIR ${SOURCE_CPP_DIR}/lightgbm)
ADD_DEFINITIONS(-DUSE_SOCKET)
SET(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11 -pthread -O3 -Wextra -Wall -Wno-ignored-attributes -Wno-unknown-pragmas")
SET(LightGBM_HEADER_DIR ${SOURCE_CPP_DIR}/include)
INCLUDE_DIRECTORIES (${LightGBM_HEADER_DIR})
file(GLOB SOURCES
    ${SOURCE_GBM_DIR}/application/*.cpp
    ${SOURCE_GBM_DIR}/boosting/*.cpp
    ${SOURCE_GBM_DIR}/io/*.cpp
    ${SOURCE_GBM_DIR}/metric/*.cpp
    ${SOURCE_GBM_DIR}/objective/*.cpp
    ${SOURCE_GBM_DIR}/network/*.cpp
    ${SOURCE_GBM_DIR}/treelearner/*.cpp
)

ADD_LIBRARY( lightgbm SHARED ${SOURCE_GBM_DIR}/c_api.cpp ${SOURCE_GBM_DIR}/lightgbm_R.cpp ${SOURCES})

#native-lib
ADD_LIBRARY( native-lib SHARED ${SOURCE_CPP_DIR}/native-lib.cpp )
FIND_LIBRARY( log-lib log )
TARGET_LINK_LIBRARIES( lightgbm ${log-lib})
TARGET_LINK_LIBRARIES( native-lib ${log-lib} lightgbm)