package com.mpp.project.dataaccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

public class FileStorageUtil {
    public static final String APP_DIR = "/bxj/";

    public static boolean writeObject(File file, Object object) {
        try {
            FileOutputStream fs = new FileOutputStream(file);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(object);
            os.flush();
            os.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public static Object readObject(File file) {
        try {
            FileInputStream fs = new FileInputStream(file);
            ObjectInputStream os = new ObjectInputStream(fs);
            Object object = os.readObject();
            os.close();
            return object;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static <T> boolean writeObjects(File file, List<T> lists) {
        if (lists == null || lists.size() <= 0) {
            return false;
        }
        try {
            FileOutputStream fs = new FileOutputStream(file, true);
            ObjectOutputStream os = null;
            if (file.length() < 1) {
                os = new ObjectOutputStream(fs);
            } else {
                os = new AppendableObjectOutputStream(fs);
            }
            for (T object : lists) {
                os.writeObject(object);
            }
            os.flush();
            fs.flush();
            os.close();
            fs.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    private static FileInputStream fs;
    private static ObjectInputStream os;

    public static <T> List<T> readObjects(File file) {
        List<T> lists = new ArrayList<T>();
        try {
            fs = new FileInputStream(file);
            os = new ObjectInputStream(fs);
            Object obj = null;
            while ((obj = os.readObject()) != null) {
                lists.add((T) os.readObject());
            }
            os.close();
            fs.close();
        } catch (Exception e) {
            try {
                os.close();
                fs.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return lists;
    }

    /**
     * Don't include header when writeObject, that use for deserializable
     */
    static class AppendableObjectOutputStream extends ObjectOutputStream {

        protected AppendableObjectOutputStream() throws IOException {
            super();
        }

        public AppendableObjectOutputStream(OutputStream output)
                throws IOException {
            super(output);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            // do nothing for 方便反序列化时正常读取
        }

    }

}
