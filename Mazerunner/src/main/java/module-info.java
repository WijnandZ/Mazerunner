module mazerunner {
    requires hanyaeger;

    exports nl.han.mazerunner;
    exports nl.han.mazerunner.entities.map;

    opens audio;
    opens backgrounds;
    opens sprites;
    exports nl.han.mazerunner.entities.map.tiles;
}
