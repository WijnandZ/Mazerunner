module mazerunner {
    requires hanyaeger;

    exports nl.han.mazerunner;
    exports nl.han.mazerunner.entities.map;
    exports nl.han.mazerunner.entities.map.tiles;
    exports nl.han.mazerunner.entities.boobytraps;

    opens audio;
    opens backgrounds;
    opens sprites;

}
