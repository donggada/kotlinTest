package com.example.kotlinTest.naver;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Test3 {
    @Test
    public void test () {
        Version version = new Version(null);
    }


    @Test
    public void exampleTest() {
        Version version = new Version("3.8.0");
        assertThat(version.toString()).isEqualTo("Version{3.8.0}");
        assertThat(version.isSnapshot).isFalse();
    }

    @Test
    public void exampleTest2() {
        Version version = new Version("3.8.0-SNAPSHOT");
        assertThat(version.toString()).isEqualTo("Version{3.8.0-SNAPSHOT}");
        assertThat(version.isSnapshot).isTrue();
    }


    @Test
    public void versionComparison1() {
        Version v1 = new Version("1.0.0");
        Version v2 = new Version("1.0.1");
        assertThat(v1.compareTo(v2)).isEqualTo(-1);
    }

    @Test
    public void versionComparison2() {
        Version v1 = new Version("1.0.0");
        Version v2 = new Version("1.3.1");
        assertThat(v1.compareTo(v2)).isEqualTo(-1);
    }

    @Test
    public void versionComparison4() {
        Version v1 = new Version("1.0.0");
        Version v2 = new Version("2.0.0-SNAPSHOT");
        assertThat(v1.compareTo(v2)).isEqualTo(-1);
    }

    @Test
    public  void versionComparison3() {
        Version v1 = new Version("1.0.0");
        Version v2 = new Version("2.0.0");
        assertThat(v1.compareTo(v2)).isEqualTo(-1);
    }

    @Test
    public void versionComparison5() {
        Version v1 = new Version("1.0.0");
        Version v2 = new Version("1.0.0-SNAPSHOT");
        assertThat(v1.compareTo(v2)).isEqualTo(1);
    }

    @Test
    public void invalidVersionThrowsException1() {
        assertThatThrownBy(() -> new Version(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorVersionMustNotBeNull);
    }

    @Test
    public void invalidVersionThrowsException2() {
        assertThatThrownBy(() -> new Version(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorVersionMustNotBeNull);

    }

    @Test
    public void invalidVersionThrowsException3() {
        assertThatThrownBy(() -> new Version("a.b.c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorVersionMustMatchPattern);
    }

    @Test
    public void invalidVersionThrowsException4() {
        assertThatThrownBy(() -> new Version("1.0.0.0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorVersionMustMatchPattern);
    }

    static final String errorVersionMustNotBeNull = "'version' must not be null!";
    static final String errorOtherMustNotBeNull =  "'other' must not be null!";
    static final String errorVersionMustMatchPattern =  "'version' must match: 'major.minor.patch(-SNAPSHOT)'!";

    class Version implements Comparable<Version> {
        private final int x;
        private final int y;
        private final int z;
        private boolean isSnapshot;
        private static final Pattern pattern = Pattern.compile("^(\\d+)(?:\\.(\\d+))?(?:\\.(\\d+))?(-SNAPSHOT)?$");
        Version(String version) {
            if (version == null || version.isEmpty()) {
                throw new IllegalArgumentException(errorVersionMustNotBeNull);
            }

            Matcher matcher = pattern.matcher(version);

            if (!matcher.matches()) {
                throw new IllegalArgumentException(errorVersionMustMatchPattern);
            }
            this.x = Integer.parseInt(matcher.group(1));
            this.y = matcher.group(2) != null ? Integer.parseInt(matcher.group(2)) : 0;
            this.z = matcher.group(3) != null ? Integer.parseInt(matcher.group(3)) : 0;
            this.isSnapshot = matcher.group(4) != null && matcher.group(4).equals("-SNAPSHOT");
        }

        boolean isSnapshot() {
            return isSnapshot;
        }

        @Override
        public int compareTo(Version other) {
            if (other == null) {
                throw new IllegalArgumentException(errorOtherMustNotBeNull);
            }

            if (this.x != other.x) {
                return Integer.compare(this.x, other.x);
            }

            if (this.y != other.y) {
                return Integer.compare(this.y, other.y);
            }

            if (this.z != other.z) {
                return Integer.compare(this.z, other.z);
            }

            if (this.isSnapshot &&  !other.isSnapshot) {
                return -1;
            }

            if (!this.isSnapshot && other.isSnapshot) {
                return 1;
            }

            return 0;
        }

        @Override
        public String toString() {
            return "Version{" + x + "." + y + "." + z + (isSnapshot ? "-SNAPSHOT" : "") + "}";
        }
    }

}
