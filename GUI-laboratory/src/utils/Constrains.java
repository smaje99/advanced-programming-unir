package utils;

import java.awt.Component;
import java.awt.Container;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

public abstract class Constrains {
    /**
     * Añade y distribuye el componente dentro del eje X y Y de la interfaz gráfica
     *
     * @param view      {@link java.awt.Component} a aplicar el {@link GridBagConstraints}
     *                                            y a añadir en {@link java.awt.Container}
     * @param pos       posicionamiento del componente
     * @param weight    dispersión al eje X y Y
     * @param insets    margen del componente
     * @param place     ubicación y llenado dentro del espacio del grid
     */
    public static void addComp(View view, Rectangle pos, Weight weight, Insets insets, Point place) {
        GridBagConstraints grid = grid(pos, insets, place);
        grid.weightx = weight.x;
        grid.weighty = weight.y;
        view.addComponent(grid);
    }

    /**
     * Añade y distribuye el componente dentro del eje X de la interfaz gráfica
     *
     * @param view      {@link java.awt.Component} a aplicar el {@link GridBagConstraints}
     *                                            y a añadir en {@link java.awt.Container}
     * @param pos       posicionamiento del componente
     * @param weightx   dispersión al eje X
     * @param insets    margen del componente
     * @param place     ubicación y llenado dentro del espacio del grid
     */
    public static void addCompX(View view, Rectangle pos, double weightx, Insets insets, Point place) {
        GridBagConstraints grid = grid(pos, insets, place);
        grid.weightx = weightx;
        view.addComponent(grid);
    }

    /**
     * Añade y distribuye el componente dentro del eje Y de la interfaz gráfica
     *
     * @param view      {@link java.awt.Component} a aplicar el {@link GridBagConstraints}
     *                                            y a añadir en {@link java.awt.Container}
     * @param pos       posicionamiento del componente
     * @param weighty   dispersión al eje Y
     * @param insets    margen del componente
     * @param place     ubicación y llenado dentro del espacio del grid
     */
    public static void addCompY(View view, Rectangle pos, double weighty, Insets insets, Point place) {
        GridBagConstraints grid = grid(pos, insets, place);
        grid.weighty = weighty;
        view.addComponent(grid);
    }

    /**
     * Añade y distribuye el componente dentro del eje X y Y de la interfaz gráfica con un tamaño fijo hacia el eje X y Y
     *
     * @param view      {@link java.awt.Component} a aplicar el {@link GridBagConstraints}
     *                                            y a añadir en {@link java.awt.Container}
     * @param pos       posicionamiento del componente
     * @param weight    dispersión hacia ambos ejes
     * @param insets    margen del componente
     * @param ipad      tamaño fijo hacia ambos ejes
     * @param place     ubicación y llenado dentro del espacio del grid
     */
    public static void addCompI(View view, Rectangle pos, Weight weight, Insets insets, Point ipad, Point place) {
        GridBagConstraints grid = grid(pos, insets, place);
        grid.weightx = weight.x;
        grid.weighty = weight.y;
        grid.ipadx = ipad.x;
        grid.ipady = ipad.y;
        view.addComponent(grid);
    }

    /**
     * Añade y distribuye el componente dentro del eje X y Y de la interfaz gráfica con un tamaño fijo hacia el eje X
     *
     * @param view      {@link java.awt.Component} a aplicar el {@link GridBagConstraints}
     *                                            y a añadir en {@link java.awt.Container}
     * @param pos       posicionamiento del componente
     * @param weight    dispersión al eje X y Y
     * @param insets    margen del componente
     * @param ipadx     tamaño fijo hacia el eje X
     * @param place     ubicación y llenado dentro del espacio del grid
     */
    public static void addCompIx(View view, Rectangle pos, Weight weight, Insets insets, int ipadx, Point place) {
        GridBagConstraints grid = grid(pos, insets, place);
        grid.weightx = weight.x;
        grid.weighty = weight.y;
        grid.ipadx = ipadx;
        view.addComponent(grid);
    }

    /**
     * Añade y distribuye el componente dentro del eje X y Y de la interfaz gráfica con un tamaño fijo hacia el eje Y
     *
     * @param view      {@link java.awt.Component} a aplicar el {@link GridBagConstraints}
     *                                            y a añadir en {@link java.awt.Container}
     * @param pos       posicionamiento del componente
     * @param weight    dispersión al eje X y Y
     * @param insets    margen del componente
     * @param ipady     tamaño fijo hacia el eje Y
     * @param place     ubicación y llenado dentro del espacio del grid
     */
    public static void addCompIy(View view, Rectangle pos, Weight weight, Insets insets, int ipady, Point place) {
        GridBagConstraints grid = grid(pos, insets, place);
        grid.weightx = weight.x;
        grid.weighty = weight.y;
        grid.ipady = ipady;
        view.addComponent(grid);
    }

    /**
     * Añade y distribuye el componente dentro del eje X de la interfaz gráfica con un tamaño fijo hacia el eje X
     *
     * @param view      {@link java.awt.Component} a aplicar el {@link GridBagConstraints}
     *                                            y a añadir en {@link java.awt.Container}
     * @param pos       posicionamiento del componente
     * @param weightx   dispersión al eje X
     * @param insets    margen del componente
     * @param ipadx     tamaño fijo hacia el eje X
     * @param place     ubicación y llenado dentro del espacio del grid
     */
    public static void addCompXIx(View view, Rectangle pos, double weightx, Insets insets, int ipadx, Point place) {
        GridBagConstraints grid = grid(pos, insets, place);
        grid.weightx = weightx;
        grid.ipadx = ipadx;
        view.addComponent(grid);
    }

    /**
     * Añade y distribuye el componente dentro del eje X de la interfaz gráfica con un tamaño fijo hacia el eje Y
     *
     * @param view      {@link java.awt.Component} a aplicar el {@link GridBagConstraints}
     *                                            y a añadir en {@link java.awt.Container}
     * @param pos       posicionamiento del componente
     * @param weightx   dispersión al eje X
     * @param insets    margen del componente
     * @param ipady     tamaño fijo hacia el eje Y
     * @param place     ubicación y llenado dentro del espacio del grid
     */
    public static void addCompXIy(View view, Rectangle pos, double weightx, Insets insets, int ipady, Point place) {
        GridBagConstraints grid = grid(pos, insets, place);
        grid.weightx = weightx;
        grid.ipady = ipady;
        view.addComponent(grid);
    }

    /**
     * Añade y distribuye el componente dentro del eje Y de la interfaz gráfica con un tamaño fijo hacia el eje X
     *
     * @param view      {@link java.awt.Component} a aplicar el {@link GridBagConstraints}
     *                                            y a añadir en {@link java.awt.Container}
     * @param pos       posicionamiento del componente
     * @param weighty   dispersión al eje Y
     * @param insets    margen del componente
     * @param ipadx     tamaño fijo hacia el eje X
     * @param place     ubicación y llenado dentro del espacio del grid
     */
    public static void addCompYIx(View view, Rectangle pos, double weighty, Insets insets, int ipadx, Point place) {
        GridBagConstraints grid = grid(pos, insets, place);
        grid.weightx = weighty;
        grid.ipadx = ipadx;
        view.addComponent(grid);
    }

    /**
     * Añade y distribuye el componente dentro del eje Y de la interfaz gráfica con un tamaño fijo hacia el eje Y
     *
     * @param view      {@link java.awt.Component} a aplicar el {@link GridBagConstraints}
     *                                            y a añadir en {@link java.awt.Container}
     * @param pos       posicionamiento del componente
     * @param weighty   dispersión al eje Y
     * @param insets    margen del componente
     * @param ipady     tamaño fijo hacia el eje Y
     * @param place     ubicación y llenado dentro del espacio del grid
     */
    public static void addCompYIy(View view, Rectangle pos, double weighty, Insets insets, int ipady, Point place) {
        GridBagConstraints grid = grid(pos, insets, place);
        grid.weighty = weighty;
        grid.ipady = ipady;
        view.addComponent(grid);
    }

    /**
     * Distribución por defecto del grid
     *
     * @param pos    posicionamiento del componente
     * @param insets margen dentro del espacio del grid
     * @param place  ubicación y llenado dentro del espacio del grid
     * @return grid configurado por defecto
     */
    private static GridBagConstraints grid(Rectangle pos, Insets insets, Point place) {
        GridBagConstraints grid = new GridBagConstraints();
        grid.gridx = pos.x;
        grid.gridy = pos.y;
        grid.gridwidth = pos.width;
        grid.gridheight = pos.height;
        grid.insets = insets;
        grid.anchor = place.x;
        grid.fill = place.y;
        return grid;
    }

    public static final class View {
        private final Component component;
        private final Container container;

        /**
         * Vista del {@link Component} en el {@link Container}
         * @param component {@link Component} a añadir al {@link Container}
         * @param container {@link Container} al que se añadirá el {@link Component}
         */
        public View(final Component component, final Container container) {
            this.component = component;
            this.container = container;
        }

        /**
         * Añade el {@link Component} al {@link Container} aplicando un {@link GridBagConstraints}
         * @param grid diseño a aplicar al {@link Component} en el {@link Container}
         */
        protected void addComponent(GridBagConstraints grid) {
            container.add(component, grid);
        }
    }

    public static final class Weight extends Point2D.Double {
        /**
         * Espacio x, y en el que acomodará el {@link java.awt.Component}
         * @param x espacio de acomodo en x
         * @param y espacio de acomodo en y
         */
        public Weight(final double x, final double y) {
            super(x, y);
        }
    }
}